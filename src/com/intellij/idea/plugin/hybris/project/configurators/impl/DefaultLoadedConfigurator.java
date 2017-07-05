/*
 * This file is part of "hybris integration" plugin for Intellij IDEA.
 * Copyright (C) 2014-2016 Alexander Bartash <AlexanderBartash@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.intellij.idea.plugin.hybris.project.configurators.impl;

import com.intellij.idea.plugin.hybris.project.configurators.LoadedConfigurator;
import com.intellij.idea.plugin.hybris.project.descriptors.HybrisModuleDescriptor;
import com.intellij.idea.plugin.hybris.settings.HybrisProjectSettingsComponent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ReadAction;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultLoadedConfigurator implements LoadedConfigurator {

    @Override
    public void configure(
        final Project project,
        final List<HybrisModuleDescriptor> allModules
    ) {
        final List<String> unloadedModuleNames = allModules
            .stream()
            .filter(e -> e.getImportStatus() == HybrisModuleDescriptor.IMPORT_STATUS.UNLOADED)
            .map(e -> e.getName())
            .collect(Collectors.toList());
        ApplicationManager.getApplication().invokeAndWait(()
                                                              -> ReadAction.run(
            () -> ModuleManager.getInstance(project).setUnloadedModules(unloadedModuleNames)
                                                          )
        );
        final Set<String> unusedModuleNames = allModules
            .stream()
            .filter(e -> e.getImportStatus() == HybrisModuleDescriptor.IMPORT_STATUS.UNUSED)
            .map(e -> e.getName())
            .collect(Collectors.toSet());
        HybrisProjectSettingsComponent.getInstance(project).getState().setUnusedExtensions(unusedModuleNames);
    }
}

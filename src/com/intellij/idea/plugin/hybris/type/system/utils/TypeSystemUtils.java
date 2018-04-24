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

package com.intellij.idea.plugin.hybris.type.system.utils;

import com.intellij.idea.plugin.hybris.common.HybrisConstants;
import com.intellij.psi.PsiFile;
import com.intellij.psi.xml.XmlFile;
import org.jetbrains.annotations.Nullable;

/**
 * Created 6:46 PM 18 September 2016.
 *
 * @author Alexander Bartash <AlexanderBartash@gmail.com>
 */
@SuppressWarnings("unused")
public final class TypeSystemUtils {

    public static boolean isTypeSystemXmlFile(@Nullable final PsiFile psiFile) {
        return psiFile instanceof XmlFile && psiFile.getName().endsWith(HybrisConstants.HYBRIS_ITEMS_XML_FILE_ENDING);
    }

}

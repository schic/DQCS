/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Free Software Foundation, Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.datacleaner.beans.stringpattern;

import java.io.Serializable;

/**
 * Represents a symbol/element in a token pattern. If for example the pattern is
 * "aaa@aaa.aa", then there will be 5 symbols:
 * 表示令牌模式中的符号/元素。例如，如果模式为*“ aaa@aaa.aa”，则将有5个符号：
 * <ul>
 * <li>aaa</li>
 * <li>@</li>
 * <li>aaa</li>
 * <li>.</li>
 * <li>aa</li>
 * </ul>
 *
 * The token pattern symbol is different from a pattern in the way that it is
 * more abstract. A symbol will not retain the concrete values of most tokens.
 * Thus the information stored in a symbol will often be limited to:
 * 令牌模式符号与模式的不同之处在于更抽象。符号不会保留大多数令牌的具体值。因此，存储在符号中的信息通常将限于：
 * <ul>
 * <li>The TokenType</li>令牌类型
 * <li>The length of the symbol</li>符号的长度
 * <li>Metadata about the symbol such as: Is it a negativ number, is it
 * uppercase, does it contain decimals etc.</li>有关符号的元数据，例如：是负数，是大写，是否包含小数等。
 * </ul>
 *
 * @see Token
 *
 *
 */
public interface TokenPatternSymbol extends Serializable {

    String toSymbolicString();

    TokenType getTokenType();

    boolean isUpperCaseOnly();

    boolean isLowerCaseOnly();

    boolean isDecimal();

    boolean isNegative();

    boolean matches(Token token, TokenizerConfiguration configuration);

    int length();

    void expandLenght(int amount);

    boolean isExpandable();
}

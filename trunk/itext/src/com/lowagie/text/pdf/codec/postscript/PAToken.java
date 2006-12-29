/*
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the License.
 *
 * The Original Code is 'iText, a free JAVA-PDF library'.
 *
 * The Initial Developer of the Original Code is Bruno Lowagie. Portions created by
 * the Initial Developer are Copyright (C) 1999, 2000, 2001, 2002 by Bruno Lowagie.
 * All Rights Reserved.
 * Co-Developer of the code is Paulo Soares. Portions created by the Co-Developer
 * are Copyright (C) 2000, 2001, 2002 by Paulo Soares. All Rights Reserved.
 *
 * Contributor(s): all the names of the contributors are added in the source code
 * where applicable.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * LGPL license (the "GNU LIBRARY GENERAL PUBLIC LICENSE"), in which case the
 * provisions of LGPL are applicable instead of those above.  If you wish to
 * allow use of your version of this file only under the terms of the LGPL
 * License and not to allow others to use your version of this file under
 * the MPL, indicate your decision by deleting the provisions above and
 * replace them with the notice and other provisions required by the LGPL.
 * If you do not delete the provisions above, a recipient may use your version
 * of this file under either the MPL or the GNU LIBRARY GENERAL PUBLIC LICENSE.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the MPL as stated above or under the terms of the GNU
 * Library General Public License as published by the Free Software Foundation;
 * either version 2 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Library general Public License for more
 * details.
 *
 * If you didn't download this code from the following link, you should check if
 * you aren't using an obsolete version:
 * http://www.lowagie.com/iText/
 *
 * This class is based on a sample class by SUN.
 * The original copyright notice is as follows:
 * 
 * Copyright 1998 by Sun Microsystems, Inc.,
 * 901 San Antonio Road, Palo Alto, California, 94303, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Sun Microsystems, Inc. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Sun.
 * 
 * The license agreement can be found at this URL:
 * http://java.sun.com/products/java-media/2D/samples/samples-license.html
 * See also the file sun.txt in directory com.lowagie.text.pdf
 */

package com.lowagie.text.pdf.codec.postscript;

public class PAToken {

  static public final int IDENTIFIER = 0;
  static public final int KEY = 1;
  static public final int PROCEDURE = 2;
  static public final int MARK = 3;
  static public final int START_PROCEDURE = 4;
  static public final int END_PROCEDURE = 5;
  static public final int IMMEDIATE = 6;
  static public final int START_ARRAY = 7;
  static public final int END_ARRAY = 8;
  static public final int START_DICT = 9;
  static public final int END_DICT = 10;

  public Object value;
  public int type;

  public PAToken(Object value, int type) {
    super();
    this.value = value;
    this.type = type;
  }

  public String toString() {
    switch (this.type) {
      case IDENTIFIER:
        return "IDENTIFIER " + this.value.toString();
      case KEY:
        return "KEY " + this.value.toString();
      case PROCEDURE:
        return "PROCEDURE " + this.value.toString();
      case MARK:
        return "MARK";
      case START_PROCEDURE:
        return "START_PROCEDURE";
      case END_PROCEDURE:
        return "END_PROCEDURE";
      case IMMEDIATE:
        return "IMMEDIATE " + this.value.toString();
      case START_ARRAY:
        return "START_ARRAY";
      case END_ARRAY:
        return "END_ARRAY";
      case START_DICT:
        return "START_DICT";
      case END_DICT:
        return "END_DICT";
    }
    return this.value.toString();
  }

}

/**
 * Copyright 2011 The Open Source Research Group,
 *                University of Erlangen-Nürnberg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sweble.wikitext.engine.wom.tools;

import static org.junit.Assert.assertEquals;
import static org.sweble.wikitext.engine.wom.tools.AstWomBuilder.womComment;
import static org.sweble.wikitext.engine.wom.tools.AstWomBuilder.womHr;
import static org.sweble.wikitext.engine.wom.tools.AstWomBuilder.womPage;

import org.junit.Test;
import org.sweble.wikitext.engine.wom.WomPage;

public class WomPrinterTest
{
	@Test
	public void womPrinterCorrectlyNestsCommentInsideContainer()
	{
		WomPage womPage =
				womPage().withBody(
						womComment().build()).build();
		
		assertEquals(
				"<body>\n" +
						"  <comment> Default Comment WtText </comment>\n" +
						"</body>",
				WomPrinter.print(womPage.getBody()));
	}
	
	@Test
	public void womPrinterCorrectlyNestsBlockElementsInsideContainer()
	{
		WomPage womPage =
				womPage().withBody(
						womHr().build()).build();
		
		assertEquals(
				"<body>\n" +
						"  <hr />\n" +
						"</body>",
				WomPrinter.print(womPage.getBody()));
	}
}
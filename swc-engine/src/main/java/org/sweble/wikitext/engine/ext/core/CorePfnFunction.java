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

package org.sweble.wikitext.engine.ext.core;

import java.util.List;

import org.sweble.wikitext.engine.ExpansionFrame;
import org.sweble.wikitext.engine.ParserFunctionBase;
import org.sweble.wikitext.engine.PfnArgumentMode;
import org.sweble.wikitext.parser.nodes.Template;
import org.sweble.wikitext.parser.nodes.WikitextNode;

public abstract class CorePfnFunction
		extends
			ParserFunctionBase
{
	private static final long serialVersionUID = 1L;
	
	// =========================================================================
	
	public CorePfnFunction(PfnArgumentMode argMode, String name)
	{
		super(argMode, name);
	}
	
	public CorePfnFunction(String name)
	{
		super(name);
	}
	
	// =========================================================================
	
	@Override
	public final WikitextNode invoke(
			WikitextNode pfn,
			ExpansionFrame frame,
			List<? extends WikitextNode> argsValues)
	{
		return invoke((Template) pfn, frame, argsValues);
	}
	
	public abstract WikitextNode invoke(
			Template pfn,
			ExpansionFrame frame,
			List<? extends WikitextNode> argsValues);
}
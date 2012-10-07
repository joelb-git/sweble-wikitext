package org.sweble.wikitext.parser.nodes;

import de.fau.cs.osr.ptk.common.ast.AstNodePropertyIterator;

public class WtInternalLink
		extends
			WtInnerNode2
{
	private static final long serialVersionUID = 1L;
	
	public static final WtLinkTitle HAS_NO_TITLE = WtLinkTitle.NULL;
	
	// =========================================================================
	
	/**
	 * Only for use by de-serialization code.
	 */
	protected WtInternalLink()
	{
		super(null, null);
	}
	
	public WtInternalLink(
			String prefix,
			WtPageName target,
			String postfix)
	{
		super(target, HAS_NO_TITLE);
		setPrefix(prefix);
		setPostfix(postfix);
	}
	
	@Override
	public int getNodeType()
	{
		return NT_INTERNAL_LINK;
	}
	
	// =========================================================================
	// Properties
	
	private String prefix;
	
	public final String getPrefix()
	{
		return this.prefix;
	}
	
	public final String setPrefix(String prefix)
	{
		if (prefix == null)
			throw new NullPointerException();
		String old = this.prefix;
		this.prefix = prefix;
		return old;
	}
	
	private String postfix;
	
	public final String getPostfix()
	{
		return this.postfix;
	}
	
	public final String setPostfix(String postfix)
	{
		if (postfix == null)
			throw new NullPointerException();
		String old = this.postfix;
		this.postfix = postfix;
		return old;
	}
	
	@Override
	public final int getPropertyCount()
	{
		return 2 + getSuperPropertyCount();
	}
	
	private final int getSuperPropertyCount()
	{
		return super.getPropertyCount();
	}
	
	@Override
	public final AstNodePropertyIterator propertyIterator()
	{
		return new WtInnerNode2PropertyIterator()
		{
			@Override
			protected int getPropertyCount()
			{
				return WtInternalLink.this.getPropertyCount();
			}
			
			@Override
			protected String getName(int index)
			{
				switch (index - getSuperPropertyCount())
				{
					case 0:
						return "prefix";
					case 1:
						return "postfix";
						
					default:
						return super.getName(index);
				}
			}
			
			@Override
			protected Object getValue(int index)
			{
				switch (index - getSuperPropertyCount())
				{
					case 0:
						return WtInternalLink.this.getPrefix();
					case 1:
						return WtInternalLink.this.getPostfix();
						
					default:
						return super.getValue(index);
				}
			}
			
			@Override
			protected Object setValue(int index, Object value)
			{
				switch (index - getSuperPropertyCount())
				{
					case 0:
						return WtInternalLink.this.setPrefix((String) value);
					case 1:
						return WtInternalLink.this.setPostfix((String) value);
						
					default:
						return super.setValue(index, value);
				}
			}
		};
	}
	
	// =========================================================================
	// Children
	
	public final void setTarget(WtPageName target)
	{
		set(0, target);
	}
	
	public final WtPageName getTarget()
	{
		return (WtPageName) get(0);
	}
	
	public boolean hasTitle()
	{
		return getTitle() != HAS_NO_TITLE;
	}
	
	public final void setTitle(WtLinkTitle title)
	{
		set(1, title);
	}
	
	public final WtLinkTitle getTitle()
	{
		return (WtLinkTitle) get(1);
	}
	
	private static final String[] CHILD_NAMES = new String[] { "target", "title" };
	
	public final String[] getChildNames()
	{
		return CHILD_NAMES;
	}
}
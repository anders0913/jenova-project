package com.angelis.tera.packet.parser.parttypes;


import com.angelis.tera.packet.parser.PartType;
import com.angelis.tera.packet.parser.datatree.DataTreeNodeContainer;
import com.angelis.tera.packet.parser.datatree.LongValuePart;
import com.angelis.tera.packet.parser.datatree.ValuePart;
import com.angelis.tera.packet.parser.formattree.Part;

/**
 * 
 * @author Gilles Duboscq
 *
 */
public class LongPartType extends PartType
{
    public LongPartType(String name)
    {
        super(name);
    }

    @Override
    public ValuePart getValuePart(DataTreeNodeContainer parent, Part part)
    {
        return new LongValuePart(parent, part);
    }

    @Override
    public boolean isBlockType()
    {
        return false;
    }

    @Override
    public boolean isReadableType()
    {
        return true;
    }

    @Override
    public int getTypeByteNumber()
    {
        return 8;
    }

}

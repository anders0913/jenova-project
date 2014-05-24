package com.angelis.tera.packet.parser;

import com.angelis.tera.packet.parser.datatree.DataTreeNodeContainer;
import com.angelis.tera.packet.parser.datatree.ValuePart;
import com.angelis.tera.packet.parser.formattree.Part;
import com.angelis.tera.packet.parser.parttypes.BlockPartType;
import com.angelis.tera.packet.parser.parttypes.BlockPartType.blockType;
import com.angelis.tera.packet.parser.parttypes.DoublePartType;
import com.angelis.tera.packet.parser.parttypes.FloatPartType;
import com.angelis.tera.packet.parser.parttypes.IntBSPartType;
import com.angelis.tera.packet.parser.parttypes.IntPartType;
import com.angelis.tera.packet.parser.parttypes.IntPartType.intType;
import com.angelis.tera.packet.parser.parttypes.LongPartType;
import com.angelis.tera.packet.parser.parttypes.RawPartType;
import com.angelis.tera.packet.parser.parttypes.StringPartType;
import com.angelis.tera.packet.parser.parttypes.StringPartType.stringType;

/**
 * 
 * @author Gilles Duboscq
 * 
 */
public abstract class PartType {
    private String _name;
    public static final PartType c = new IntPartType("c", intType.c);
    public static final PartType h = new IntPartType("h", intType.h);
    public static final PartType d = new IntPartType("d", intType.d);
    public static final PartType bcc = new IntBSPartType("cbs", intType.c);
    public static final PartType bch = new IntBSPartType("bch", intType.h);
    public static final PartType bcd = new IntBSPartType("dbs", intType.d);
    public static final PartType f = new FloatPartType("f");
    public static final PartType df = new DoublePartType("df");
    public static final PartType Q = new LongPartType("Q");
    public static final PartType S = new StringPartType("S", stringType.S);
    public static final PartType s = new StringPartType("s", stringType.s);
    public static final PartType b = new RawPartType("b");
    public static final PartType x = new RawPartType("x");
    public static final PartType Ss = new StringPartType("Ss", stringType.Ss);
    public static final PartType forBlock = new BlockPartType("forblock", blockType.forblock);
    public static final PartType swicthBlock = new BlockPartType("switchblock", blockType.switchblock);
    public static final PartType block = new BlockPartType("block", blockType.block);

    public PartType(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public abstract ValuePart getValuePart(DataTreeNodeContainer parent, Part part);

    public abstract boolean isReadableType();

    public abstract boolean isBlockType();

    public abstract int getTypeByteNumber();

    @Override
    public String toString() {
        return _name;
    }
}
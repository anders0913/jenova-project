/**
 * 
 */
package com.angelis.tera.packet.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

import javolution.util.FastTable;

import com.angelis.tera.packet.gui.PacketTableRenderer.TooltipTable;
import com.angelis.tera.packet.gui.images.IconsTable;
import com.angelis.tera.packet.protocol.protocoltree.PacketFamilly.PacketDirectionEnum;
import com.angelis.tera.packet.session.DataPacket;

/**
 * @author Ulysses R. Ribeiro
 *
 */
@SuppressWarnings("serial") 
class PacketTableModel extends AbstractTableModel implements TooltipTable
{
    private static final String[] columnNames =
    {
        "S/C",
        "Opcode",
        "Time",
        "Length",
        "Name"
    };
    
    private FastTable<Object[]> _currentTable;
    
    public PacketTableModel()
    {
    }
    
    public void reinit(int size)
    {
    	_currentTable = new FastTable<Object[]>(size);
    }
    
    @Override
    public int getColumnCount() 
    {
        return columnNames.length;
    }

    @Override
    public int getRowCount() 
    {
        return (_currentTable == null ? 0 : _currentTable.size());
    }

    @Override
    public String getColumnName(int col)
    {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) 
    {
    	Object[] tableRow = _currentTable.get(row);
    	if (tableRow != null)
    		return tableRow[col];
    	return "";
    }

    @Override
    public boolean isCellEditable(int row, int col) 
    {
        	return false;
    }
    
    public void addRow(DataPacket packet, long startTime)
    {
        ImageIcon icon = null;
        if(packet.getDirection() == PacketDirectionEnum.CLIENT)
        {
            if(packet.hasError())
            {
                icon = IconsTable.ICON_FROM_CLIENT_ERROR;
            }
            else if(packet.hasWarning())
            {
                icon = IconsTable.ICON_FROM_CLIENT_WARNING;
            }
            else
            {
                icon = IconsTable.ICON_FROM_CLIENT;
            }
        }
        else
        {
            if (packet.hasError())
            {
                icon = IconsTable.ICON_FROM_SERVER_ERROR;
            }
            else if (packet.hasWarning())
            {
                icon = IconsTable.ICON_FROM_SERVER_WARNING;
            }
            else
            {
                icon = IconsTable.ICON_FROM_SERVER;
            }
        }
        String opcode = null;
        if(packet.getPacketFormat() != null)
        {
            opcode = packet.getPacketFormat().getOpcodeStr();
        }
        else
        {
            opcode = "-";
        }
        
        String time = "+"+(packet.getTimeStamp()-startTime)+" ms";
        String toolTip = null;
        if (packet.hasError() || packet.hasWarning())
        {
            String color = (packet.hasError() ? "red" : "gray");
            toolTip = "<br><font color=\""+color+"\">"+packet.getErrorMessage()+"</font></html>";
        }
        
        Object[] temp = { new JLabel(icon), opcode, time, String.valueOf(packet.getSize()), packet.getName(), toolTip, false};
        _currentTable.add(temp);
    }

    @Override
    public String getToolTip(int row, int col)
    {
        String toolTip = "<html>Packet: "+row;
        Object msg = _currentTable.get(row)[5];
        if (msg != null)
        {
            toolTip += msg;
        }
        return toolTip;
    }
    
    public void setIsMarked(int row, boolean val)
    {
        _currentTable.get(row)[6] = val;
    }
    
    @Override
    public boolean getIsMarked(int row)
    {
        return (Boolean) _currentTable.get(row)[6];
    }
}


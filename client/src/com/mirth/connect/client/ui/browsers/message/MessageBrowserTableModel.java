/*
 * Copyright (c) Mirth Corporation. All rights reserved.
 * http://www.mirthcorp.com
 * 
 * The software in this package is published under the terms of the MPL
 * license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 */

package com.mirth.connect.client.ui.browsers.message;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeSet;

import org.jdesktop.swingx.treetable.MutableTreeTableNode;

import com.mirth.connect.client.ui.AbstractSortableTreeTableNode;
import com.mirth.connect.client.ui.SortableTreeTableModel;
import com.mirth.connect.donkey.model.message.ConnectorMessage;
import com.mirth.connect.donkey.model.message.Message;
import com.mirth.connect.donkey.model.message.Status;

public class MessageBrowserTableModel extends SortableTreeTableModel {
    private AbstractSortableTreeTableNode root;
    
    public MessageBrowserTableModel() {
        root = new AbstractSortableTreeTableNode() {
            @Override
            public Object getValueAt(int column) {
                return null;
            }

            @Override
            public int getColumnCount() {
                return 0;
            }
        };
        
        setRoot(root);
    }
    
    @Override
    public int getHierarchicalColumn() {
        return 0;
    }
    
    @Override
    public Class<?> getColumnClass(int column) {
        // TODO This method doesn't seem to be used. Double check and remove if that is the case
        /*switch (column) {
            case 0:
                return Calendar.class;
            case 2:
                return Status.class; 
            default: 
                return String.class;
        }*/
        return null;
    }
    
    public void addMessage(Message message) {
        Map<Integer, ConnectorMessage> connectorMessages = message.getConnectorMessages();
        
        MessageBrowserTableNode sourceNode;
        if (connectorMessages.containsKey(0)) {
            sourceNode = new MessageBrowserTableNode(connectorMessages.get(0), this);
        } else {
            sourceNode = new MessageBrowserTableNode(message.getMessageId());
        }
        
        insertNodeInto(sourceNode, root);
        
        // reorder the connectors by their natural order
        TreeSet<Integer> keys = new TreeSet<Integer>(message.getConnectorMessages().keySet()); 
        
        // add the connector messages as child nodes
        for (Integer key : keys) {
            if (key > 0) {            
                ConnectorMessage connectorMessage = message.getConnectorMessages().get(key);
                insertNodeInto(new MessageBrowserTableNode(connectorMessage, this), sourceNode);
            }
        }
    }
    
    public void clear() {
        int childCount = root.getChildCount();
        
        for (int i = 0; i < childCount; i++) {
            removeNodeFromParent((MutableTreeTableNode) root.getChildAt(0));
        }
    }
}

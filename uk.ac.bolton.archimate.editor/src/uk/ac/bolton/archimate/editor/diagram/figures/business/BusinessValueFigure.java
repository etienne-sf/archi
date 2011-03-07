/*******************************************************************************
 * Copyright (c) 2010 Bolton University, UK.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 *******************************************************************************/
package uk.ac.bolton.archimate.editor.diagram.figures.business;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;

import uk.ac.bolton.archimate.editor.diagram.figures.AbstractEditableTextFlowFigure;
import uk.ac.bolton.archimate.model.IDiagramModelArchimateObject;



/**
 * Business Service Figure
 * 
 * @author Phillip Beauvoir
 */
public class BusinessValueFigure extends AbstractEditableTextFlowFigure {

    int SHADOW_OFFSET = 2;
    
    public BusinessValueFigure(IDiagramModelArchimateObject diagramModelObject) {
        super(diagramModelObject);
    }
    
    @Override
    public void drawFigure(Graphics graphics) {
        Rectangle bounds = getBounds();
        
        graphics.setAlpha(100);
        graphics.setBackgroundColor(ColorConstants.black);
        graphics.fillOval(bounds.x + SHADOW_OFFSET, bounds.y + SHADOW_OFFSET, bounds.width - SHADOW_OFFSET, bounds.height  - SHADOW_OFFSET);

        graphics.setAlpha(255);
        graphics.setBackgroundColor(getFillColor());
        graphics.fillOval(bounds.x, bounds.y, bounds.width - SHADOW_OFFSET, bounds.height - SHADOW_OFFSET);
        
        // Outline
        graphics.setForegroundColor(ColorConstants.black);
        graphics.drawOval(bounds.x, bounds.y, bounds.width - SHADOW_OFFSET - 1, bounds.height - SHADOW_OFFSET - 1);
    }

    @Override
    protected void drawTargetFeedback(Graphics graphics) {
        graphics.pushState();
        graphics.setForegroundColor(ColorConstants.blue);
        graphics.setLineWidth(2);
        graphics.drawRectangle(new Rectangle(bounds.x + 1, bounds.y + 1, bounds.width - SHADOW_OFFSET - 1, bounds.height - SHADOW_OFFSET - 1));
        graphics.popState();
    }

    public Rectangle calculateTextControlBounds() {
        Rectangle bounds = getBounds().getCopy();
        bounds.x += 20;
        bounds.y += 10;
        bounds.width = bounds.width - 40;
        bounds.height -= 15;
        
        translateFromParent(bounds);
        
        return bounds;
    }

    @Override
    protected Image getImage() {
        return null;
    }
}
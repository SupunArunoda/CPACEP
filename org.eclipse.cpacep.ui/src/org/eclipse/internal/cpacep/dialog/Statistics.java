package org.eclipse.internal.cpacep.dialog;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.FrameworkUtil;

public class Statistics extends TitleAreaDialog {


    public Statistics(Shell parentShell) {
        super(parentShell);
        
    }

    @Override
    public void create() {
        super.create();
        setTitle("Statistics");
        setMessage("This shows the statistics generated by CPAChecker", IMessageProvider.INFORMATION);
        setTitleImage(getImage(new Path("icons/cpac_logo.png")));
        
    }
    
    public Image getImage(Path path) {
	ImageDescriptor imageDescriptor=ImageDescriptor.createFromURL(FileLocator.find(FrameworkUtil.getBundle(this.getClass()), path, null));
	return imageDescriptor.createImage();
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout layout = new GridLayout(2, false);
        container.setLayout(layout);

        return area;
    }

    @Override
    protected boolean isResizable() {
        return true;
    }


    @Override
    protected void okPressed() {
        super.okPressed();
    }

}
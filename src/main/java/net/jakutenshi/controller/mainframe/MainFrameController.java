package net.jakutenshi.controller.mainframe;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.model.entities.Organization;
import net.jakutenshi.model.tables.AbstractTable;
import net.jakutenshi.model.tables.Model;
import net.jakutenshi.ui.MainFrame;
import net.jakutenshi.ui.forms.EntityForm;
import net.jakutenshi.ui.forms.OrganizationForm;
import net.jakutenshi.ui.views.*;

import javax.swing.*;

public class MainFrameController extends Controller<JFrame, Object> {

    private OrganizationsController organizationsController;
    private PostController          postController;
    private EmploeesController      emploeesController;
    private SalaryController        salaryController;
    private DutyLogController       dutyLogController;

    private int selectedPostID;

    public MainFrameController() {
        super();

        this.organizationsController = new OrganizationsController();
        organizationsController.setRoot(this).setView(new OrganizationsView(organizationsController)).setModel(Model.ORGANIZATIONS);
        this.postController          = new PostController(this,          new PostView(),          Model.POSTS);
        this.emploeesController      = new EmploeesController(this,      new EmploeesView(),      Model.EMPLOYEES);
        this.salaryController        = new SalaryController(this,        new SalaryView(),        Model.POSTS);
        this.dutyLogController       = new DutyLogController(this,       new DutyLogView(),       Model.DUTIES);

        MainFrame mainFrame = new MainFrame(
                organizationsController.getView(),
                postController.getView(),
                emploeesController.getView(),
                salaryController.getView(),
                dutyLogController.getView()
        );

        this.setView(mainFrame);
        this.getView().setVisible(true);
    }
}

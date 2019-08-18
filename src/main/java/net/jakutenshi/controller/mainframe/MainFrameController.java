package net.jakutenshi.controller.mainframe;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.model.ModelsMap;
import net.jakutenshi.model.entities.OrgObject;
import net.jakutenshi.model.entities.Organization;
import net.jakutenshi.model.sql.DBTables;
import net.jakutenshi.model.tables.AbstractTable;
import net.jakutenshi.model.tables.Model;
import net.jakutenshi.ui.MainFrame;
import net.jakutenshi.ui.forms.EntityForm;
import net.jakutenshi.ui.forms.OrganizationForm;
import net.jakutenshi.ui.views.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainFrameController extends Controller<JFrame> {

    private OrganizationsController organizationsController;
    private PostController          postController;
    private EmploeesController      emploeesController;
    private SalaryController        salaryController;
    private DutyLogController       dutyLogController;

    private int selectedPostID;

    public MainFrameController() {
        super();

        this.organizationsController = new OrganizationsController();
        ModelsMap organizationsControllerModelsMap = new ModelsMap();
        organizationsControllerModelsMap.addModel("organizations", Model.ORGANIZATIONS);
        organizationsControllerModelsMap.addModel("objects", new AbstractTable<OrgObject>(DBTables.ORG_OBJECT, new ArrayList<>()));
        organizationsController
                .setRoot(this)
                .setView(new OrganizationsView(organizationsController))
                .setModels(organizationsControllerModelsMap);
        this.postController          = new PostController(this,     new PostView(),     null);
        this.emploeesController      = new EmploeesController(this, new EmploeesView(), null);
        this.salaryController        = new SalaryController(this,   new SalaryView(),   null);
        this.dutyLogController       = new DutyLogController(this,  new DutyLogView(),  null);

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

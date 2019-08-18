package net.jakutenshi.controller;

import jdk.vm.ci.meta.Constant;
import net.jakutenshi.model.ModelsMap;
import net.jakutenshi.model.tables.AbstractTable;

import java.awt.*;
import java.util.LinkedHashMap;

public class Controller<C extends Component> {
    private Controller root;
    private C view;
    private ModelsMap models;

    public Controller() {
        this.root  = null;
        this.view  = null;
        this.models = new ModelsMap();
    }

    public Controller(Controller root) {
        this.root  = root;
        this.view  = null;
        this.models = new ModelsMap();
    }

    public Controller(Controller root, ModelsMap models) {
        this.root  = root;
        this.view  = null;
        this.models = models;
    }

    public Controller(Controller root, String modelName, AbstractTable model) {
        this.root  = root;
        this.view  = null;
        this.models = new ModelsMap();
        this.models.addModel(modelName, model);
    }

    public Controller(Controller root, C view) {
        this.root  = root;
        this.view  = view;
        this.models = new ModelsMap();
    }

    public Controller(Controller root, C view, ModelsMap models) {
        this.root  = root;
        this.view  = view;
        this.models = models;
    }

    public Controller(Controller root, C view, String modelName, AbstractTable model) {
        this.root  = root;
        this.view  = view;
        this.models = new ModelsMap();
        this.models.addModel(modelName, model);
    }

    public Controller getRoot() {
        return root;
    }

    public Controller setRoot(Controller root) {
        this.root = root;
        return this;
    }

    public C getView() {
        return view;
    }

    public Controller setView(C view) {
        this.view = view;
        return this;
    }

    public ModelsMap getModels() {
        return models;
    }

    public Controller setModels(ModelsMap models) {
        this.models = models;
        return this;
    }

    public Controller updateModel(String modelName, AbstractTable model) {
        this.models.updateModel(modelName, model);
        return this;
    }

    public AbstractTable getModel(String modelName) {
        return models.getModel(modelName);
    }

    public Controller addModel(String modelName, AbstractTable model) {
        this.models.addModel(modelName, model);
        return this;
    }
}

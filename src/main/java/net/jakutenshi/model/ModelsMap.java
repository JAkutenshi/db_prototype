package net.jakutenshi.model;

import net.jakutenshi.model.tables.AbstractTable;

import java.util.LinkedHashMap;

public class ModelsMap {
    LinkedHashMap<String, AbstractTable> models;

    public ModelsMap() {
        models = new LinkedHashMap<>();
    }

    public ModelsMap(LinkedHashMap<String, AbstractTable> models) {
        this.models = models;
    }

    public LinkedHashMap<String, AbstractTable> getModels() {
        return models;
    }

    public AbstractTable getModel(String modelName) {
        return models.get(modelName);
    }

    public void addModel(String modelName, AbstractTable models) {
        this.models.put(modelName, models);
    }

    public void updateModel(String modelName, AbstractTable models) {
        this.models.replace(modelName, models);
    }

    public void setModels(LinkedHashMap<String, AbstractTable> models) {
        this.models = models;
    }
}

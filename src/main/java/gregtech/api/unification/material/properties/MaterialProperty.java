package gregtech.api.unification.material.properties;

import gregtech.api.unification.material.flags.MaterialFlag;

import java.util.ArrayList;
import java.util.List;

public class MaterialProperty<T> {
    private final String name;
    private final Class<T> propertyValueType;
    private final List<MaterialFlag> requiredFlags = new ArrayList<>();
    private final List<MaterialProperty<?>> requiredProperties = new ArrayList<>();

    private MaterialProperty(String name, Class<T> propertyValueType, List<MaterialProperty<?>> requiredProperties, List<MaterialFlag> requiredFlags) {
        this.name = name;
        this.propertyValueType = propertyValueType;
        this.requiredFlags.addAll(requiredFlags);
        this.requiredProperties.addAll(requiredProperties);
    }

    public T cast(Object data) {
        return propertyValueType.cast(data);
    }

    public static class Builder<T> {
        private final String name;
        private final Class<T> propertyValueType;

        private final List<MaterialFlag> requiredFlags = new ArrayList<>();
        private final List<MaterialProperty<?>> requiredProperties = new ArrayList<>();

        public Builder(String name, Class<T> propertyValueType) {
            this.name = name;
            this.propertyValueType = propertyValueType;
        }

        public MaterialProperty.Builder<T> requires(MaterialProperty<?> property) {
            this.requiredProperties.add(property);
            return this;
        }

        public MaterialProperty.Builder<T> requires(MaterialFlag materialFlag) {
            this.requiredFlags.add(materialFlag);
            return this;
        }

        public MaterialProperty<T> build() {
            return new MaterialProperty<>(name, propertyValueType, requiredProperties, requiredFlags);
        }
    }
}

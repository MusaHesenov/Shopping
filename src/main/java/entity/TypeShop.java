package entity;

import java.util.Objects;

public class TypeShop {
    private Integer typeId;
    private String typeName;

    public TypeShop() {

    }

    public TypeShop(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeShop typeShop = (TypeShop) o;
        return typeId.equals(typeShop.typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId);
    }

    @Override
    public String toString() {
        return typeId + ". " +typeName+" ";
    }
}

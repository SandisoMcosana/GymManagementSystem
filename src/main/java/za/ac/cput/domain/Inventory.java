package za.ac.cput.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String name;
    private String description;
    private String quantity;
    private String alert_threshold;
    public Inventory() {
    }
    private Inventory(Builder builder){
        this.itemId = builder.itemId;
        this.name = builder.name;
        this.description = builder.description;
        this.quantity = builder.quantity;
        this.alert_threshold = builder.alert_threshold;
    }
    public int getItemId() {return itemId;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public String getQuantity() {return quantity;}
    public String getAlert_threshhold(){return alert_threshold;}
    @Override
    public String toString() {
        return "Inventory{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity='" + quantity + '\'' +
                ", alert_threshhold='" + alert_threshold + '\'' +
                '}';
    }
    public static class Builder{
        private int itemId;
        private String name;
        private String description;
        private String quantity;
        private String alert_threshold;
        public Builder setItemId(int itemId) {
            this.itemId = itemId;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder setQuantity(String quantity) {
            this.quantity = quantity;
            return this;
        }
        public Builder setAlert_threshold(String alert_threshold) {
            this.alert_threshold = alert_threshold;
            return this;
        }
        public Builder copy(Inventory inventory){
            this.itemId=inventory.itemId;
            this.name=inventory.name;
            this.description=inventory.description;
            this.quantity=inventory.quantity;
            this.alert_threshold=inventory.alert_threshold;
            return this;
        }
        public Inventory build(){
            return new Inventory(this);
        }
    }
}

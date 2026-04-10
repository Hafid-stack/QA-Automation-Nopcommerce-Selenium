package models;

public class CartItem {

        private int price;
        private int quantity;
        private int total;

        // constructor + getters

        public CartItem(int price, int quantity, int total) {
            this.price = price;
            this.quantity = quantity;
            this.total = total;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }


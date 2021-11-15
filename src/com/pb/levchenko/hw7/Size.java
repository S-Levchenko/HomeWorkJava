package com.pb.levchenko.hw7;

public enum Size {
    XXS(" Детский размер ",32) {
        @Override
        public String getDescription() {
            return (" Детский размер ");
        }
    },
    XS (" Взрослый размер",34) {
        @Override
        public int getEuroSize() {
            return 34;
        }
    },
    S (" Взрослый размер",36){
        @Override
        public int getEuroSize() {
            return 36;
        }
    },
    M (" Взрослый размер",38){
        @Override
        public int getEuroSize() {
            return 38;
        }
    },
    L (" Взрослый размер",40){
        @Override
        public int getEuroSize() {
            return 40;
        }
    };

    public String getDescription() {
        return (" Взрослый размер ");

    }

    public int getEuroSize() {
        return 32;
    }


    Size(String description, int euroSize) {
        this.description = description;
        this.euroSize = euroSize;
    }

    String description;
    int euroSize;

}






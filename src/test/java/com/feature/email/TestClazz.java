package com.feature.email;

import lombok.Data;

public class TestClazz {

    public static void main(String[] args) {
        //车子跑起来
        Car car = new Car(1, "白", "特斯拉");
        car.runCar(car);
    }

    @Data
    static
    class Car {
        private int wheelNum;   //轮子数量
        private String color;   //颜色
        private String name;    //车子名字/型号

        Car(int wheelNum, String color, String name) {
            this.wheelNum = wheelNum;
            this.color = color;
            this.name = name;
        }

        public void runCar(Car car) {
            if (4 == car.getWheelNum()) {
                System.out.println("车子跑了起来");
            } else {
                Factory factory = new Factory("龙哥修理厂", "666688888", "金山大道钻石一号店铺");
                factory.fixCar(car);
            }
        }
    }

    @Data
    static class Factory {
        private String name;
        private String mobile;
        private String addr;

        Factory(String name, String mobile, String addr) {
            this.name = name;
            this.mobile = mobile;
            this.addr = addr;
        }

        public void printMsg() {
            System.out.println("来到了" + this.getAddr() + this.getName() + ",修理厂电话:" + this.getMobile());
        }

        public void fixCar(Car car) {
            printMsg();
            System.out.println("修理了一辆只有:" + car.getWheelNum() + "个轮子的" +
                    car.getColor() + "色" + car.getName() + "汽车");
            car.setWheelNum(4);
            System.out.println("修理后轮子数量:" + car.getWheelNum() + "个");
        }

    }

}

package com.interTest.patterns.Factori;




public class NoReflection {
    private class Inner{
        public void byAlive(){
            System.out.println("Im here");
        }
    }
    public Inner getInner(){
        return new Inner();
    }
}

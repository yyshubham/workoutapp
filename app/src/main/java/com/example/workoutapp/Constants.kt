package com.example.workoutapp

class Constants {
    companion object{
        fun defaultexcercsielist():ArrayList<excerciselayout>{
            val arr=ArrayList<excerciselayout>()
            val pushups=excerciselayout(1, "pushups", R.drawable.pushups,false,false)
            arr.add(pushups);
            val burpees=excerciselayout(2, "burpees", R.drawable.burpees,false,false)
            arr.add(burpees);
            val calf =excerciselayout(3, "Calf Raisen", R.drawable.calfraisen,false,false)
            arr.add(calf);
            val chairsq=excerciselayout(4, "chair squarts", R.drawable.chairsquats,false,false)
            arr.add(chairsq);
            val standingl=excerciselayout(5, "Standing lateral raise", R.drawable.standinglateralraise,false,false)
            arr.add(standingl);
            val lunges=excerciselayout(6, "Lunges", R.drawable.lunges,false,false)
            arr.add(lunges);

            val squarts=excerciselayout(7, "Squarts", R.drawable.squats,false,false)
            arr.add(squarts);

            return arr
        }

    }
}
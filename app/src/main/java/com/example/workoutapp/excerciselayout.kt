package com.example.workoutapp

class excerciselayout(private var id:Int,
                        private var name:String,
                        private var image:Int,
                        private var iscompleted:Boolean,
                        private var isselected:Boolean) {

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getImage(): Int {
        return image
    }

    fun setImage(image: Int) {
        this.image = image
    }

    fun getIsCompleted(): Boolean {
        return iscompleted
    }

    fun setIsCompleted(isCompleted: Boolean) {
        this.iscompleted = isCompleted
    }

    fun getIsSelected(): Boolean {
        return isselected
    }

    fun setIsSelected(isSelected: Boolean) {
        this.isselected = isSelected
    }



}
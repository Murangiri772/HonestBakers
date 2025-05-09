package com.lewishr.honestbakers.navigation

const val ROUT_HOME = "home"
const val ROUT_ABOUT = "about"
const val ROUT_MENU = "menu"
const val ROUT_START = "start"
const val ROUT_REGISTER = "Register"
const val ROUT_LOGIN = "Login"
const val ROUT_RECIPE = "recipe"
const val ROUT_CHAT = "chat"
const val ROUT_PAYMENT = "payment"
const val ROUT_LOCATION = "location"
const val ROUT_SPLASH = "splash"
const val ROUT_PROFILE = "profile"
//Products

const val ROUT_ADD_BAKES = "add_bakes"
const val ROUT_BAKES_LIST = "bakes_list"
const val ROUT_EDIT_BAKES = "edit_bakes/{bakesId}"

// ✅ Helper function for navigation
fun editBakesRoute(bakesId: Int) = "edit_bakes/$bakesId"
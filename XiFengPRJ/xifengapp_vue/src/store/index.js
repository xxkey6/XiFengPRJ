import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
    pdt: {
        id: '',
        name: '',
        type: '',
        unitPrice: '',
        amount: ''
    },
    // 顶部一级菜单栏
    headerList:[
        {path: '/home', title: '首页'},
        {path: '/shop1', title: '提瓦特军火商'},
        {path: '/shop2', title: '万民堂'},
        {path: '/shop3', title: '荣光之风'},
        {path: '/shop4', title: '须弥植物园'},
    ],
    types:[
        {index: 1, type: '武器'},
        {index: 2, type: '矿石'},
        {index: 3, type: '食物'},
        {index: 4, type: '饮品'},
        {index: 5, type: '观赏品'},
        {index: 6, type: '植物'},
        {index: 7, type: '水果'},
    ],
    typeList:[
        [
            {path: 'shop1-1', title: '武器'},
            {path: 'shop1-2', title: '矿石'}
        ],
        [
            {path: 'shop2-1', title: '食物'},
            {path: 'shop2-2', title: '饮品'}
        ],
        [
            {path: 'shop3-1', title: '观赏品'},
        ],
        [
            {path: 'shop4-1', title: '植物'},
            {path: 'shop4-2', title: '水果'}
        ],
    ],


    insertFormVisible: false,
    updateFormVisible: false,
    orderFormVisible: false,

}

const actions = {

}

const mutations = {
    UpVisible(state){
        state.updateFormVisible = true;
    },
    UpInvisible(state){
        state.updateFormVisible = false;
    },
    InVisible(state){
        state.insertFormVisible = true;
    },
    InInvisible(state){
        state.insertFormVisible = false;
    },
    OdVisible(state){
        state.orderFormVisible = true;
    },
    OdInvisible(state){
        state.orderFormVisible = false;
    },


    ClearPdt(state){
        state.pdt = {
            id: 0,
            name: '',
            type: '',
            unitPrice: 0,
            amount: 0
        }
    },
    
}

export default new Vuex.Store({
    state,
    actions,
    mutations
})

webpackJsonp([14],{MOcU:function(t,s){},eZ4f:function(t,s,a){"use strict";Object.defineProperty(s,"__esModule",{value:!0});var e={name:"course",data:function(){return{choosed:"未完成课程设计教学",items:[1,1,1]}},methods:{openLink:function(){this.$router.push({path:"newworks"})},delworks:function(){var t=this;this.$confirm("确定要删除吗？","提示",{type:"warning"}).then(function(){t.$message.success("删除成功"),t.tableData.splice(index,1)}).catch(function(){})}}},n={render:function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticClass:"sworks"},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-lx-calendar"}),t._v(" 作业项目\n            ")])],1)],1),t._v(" "),a("div",{staticClass:"container"},[a("div",{staticClass:"form"},[a("div",{staticClass:"form-top"},[a("el-button",{staticClass:"fr",attrs:{type:"primary",size:"small"},on:{click:t.openLink}},[t._v("新建作业项目")])],1),t._v(" "),a("div",{staticClass:"cont"},[t._l(t.items,function(s){return a("div",{staticClass:"cont-one"},[t._m(0,!0),t._v(" "),a("div",{staticClass:"one-right"},[a("p",[a("el-button",{attrs:{type:"danger",size:"mini",plain:""},on:{click:t.delworks}},[t._v("删除作业")])],1),t._v(" "),a("p",[a("el-button",{attrs:{type:"primary",size:"mini",plain:""},on:{click:t.openLink}},[t._v("编辑作业")])],1)])])}),t._v(" "),a("div",{staticClass:"pagination"},[a("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:1e3}})],1)],2)])])])},staticRenderFns:[function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticClass:"one-left"},[a("h2",[t._v("作业项目一")]),t._v(" "),a("p",{staticClass:"stu-num"},[a("span",[t._v("创建者：李明明")]),t._v(" "),a("span",{staticStyle:{"margin-left":"20px"}},[t._v("创建时间：2019-10-15 12:00")])]),t._v(" "),a("p",{staticClass:"work-time"},[t._v("简介：阿嘎国家理科高建安路价格拉开关商量个家里开始价格两三个睡觉了攻击力关键是两个垃圾赶快拉几个拉几个垃圾啊考虑过价来看哥吉拉开个家里宫颈癌离开过阿嘎国家理科高建安路价格拉开关商量个家里开始价格两三个睡觉了攻击力关键是两个垃圾赶快拉几个拉几个垃圾啊考虑过价来看哥吉拉开个家里宫颈癌离开过")]),t._v(" "),a("p",{staticClass:"data"},[t._v("资料："),a("span",[t._v("上来讲是客观.png")])]),t._v(" "),a("p",{staticClass:"status"},[t._v("使用："),a("span",[t._v("13次")])])])}]};var i=a("VU/8")(e,n,!1,function(t){a("MOcU")},"data-v-cbc24a1e",null);s.default=i.exports}});
//# sourceMappingURL=14.a1a74bcff82b8114b0c2.js.map
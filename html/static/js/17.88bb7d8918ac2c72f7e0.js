webpackJsonp([17],{eZ4f:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n=a("Xxa5"),s=a.n(n),r=a("exGp"),i=a.n(r),o=a("mrNh"),c={name:"course",data:function(){return{loading:!1,pageNum:1,pageSize:10,total:0,tableData:[]}},mounted:function(){this.Getworkprojectlist()},methods:{openLink:function(t){this.$openBlank("newworks",{type:t})},delworks:function(t){var e=this;this.$confirm("确定要删除吗？","提示",{type:"warning"}).then(function(){e.Deleteworkproject(t)}).catch(function(){})},Deleteworkproject:function(t){var e=this;return i()(s.a.mark(function a(){var n,r;return s.a.wrap(function(a){for(;;)switch(a.prev=a.next){case 0:return n=e.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),a.prev=1,a.next=4,Object(o.A)(t);case 4:0==(r=a.sent).status.code?(e.$message({message:"删除成功",type:"success"}),e.Getworkprojectlist()):e.$message.error(r.status.description),a.next=11;break;case 8:a.prev=8,a.t0=a.catch(1),console.log(a.t0);case 11:return a.prev=11,n.close(),a.finish(11);case 14:case"end":return a.stop()}},a,e,[[1,8,11,14]])}))()},changePage:function(t){this.pageNum=t,this.Getworkprojectlist()},Getworkprojectlist:function(){var t=this;return i()(s.a.mark(function e(){var a,n,r;return s.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return t.loading=!0,a=t.pageNum,n=t.pageSize,e.prev=2,e.next=5,Object(o.S)(a,n);case 5:0==(r=e.sent).status.code?(t.total=r.result.total,t.tableData=r.result.list):t.$message.error(r.status.description),e.next=12;break;case 9:e.prev=9,e.t0=e.catch(2),console.log(e.t0);case 12:return e.prev=12,t.loading=!1,e.finish(12);case 15:case"end":return e.stop()}},e,t,[[2,9,12,15]])}))()}}},l={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"sworks"},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-lx-calendar"}),t._v(" 作业项目\n            ")])],1)],1),t._v(" "),a("div",{staticClass:"container"},[a("div",{staticClass:"form"},[a("div",{staticClass:"form-top"},[a("el-button",{staticClass:"fr",attrs:{type:"primary",size:"small"},on:{click:function(e){return t.openLink(0)}}},[t._v("新建作业项目")])],1),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticClass:"cont"},[t._l(t.tableData,function(e){return a("div",{staticClass:"cont-one"},[a("div",{staticClass:"one-left"},[a("h2",[t._v(t._s(e.name))]),t._v(" "),a("p",{staticClass:"stu-num"},[a("span",[a("strong",[t._v("创建者：")]),t._v(t._s(e.creatorName))]),t._v(" "),a("span",{staticStyle:{"margin-left":"20px"}},[a("strong",[t._v("创建时间：")]),t._v(t._s(e.createtime))])]),t._v(" "),a("p",{staticClass:"work-time"},[a("strong",[t._v("简介：")]),t._v(t._s(e.desc))]),t._v(" "),a("p",{staticClass:"data"},[a("strong",[t._v("资料：")]),t._l(e.fileName,function(e){return a("span",{staticStyle:{"margin-right":"20px"}},[t._v(t._s(e))])})],2),t._v(" "),a("p",{staticClass:"status"},[a("strong",[t._v("使用：")]),a("span",[t._v(t._s(e.useCount)+"次")])])]),t._v(" "),a("div",{staticClass:"one-right"},[a("p",[a("el-button",{attrs:{type:"danger",size:"mini",plain:""},on:{click:function(a){return t.delworks(e.id)}}},[t._v("删除作业")])],1),t._v(" "),a("p",[a("el-button",{attrs:{type:"primary",size:"mini",plain:""},on:{click:function(a){return t.openLink(e.id)}}},[t._v("编辑作业")])],1)])])}),t._v(" "),a("div",{staticClass:"pagination"},[a("el-pagination",{attrs:{background:"","page-size":t.pageSize,layout:"prev, pager, next",total:t.total},on:{"current-change":t.changePage}})],1)],2)])])])},staticRenderFns:[]};var u=a("VU/8")(c,l,!1,function(t){a("nChC")},"data-v-7d05dbdc",null);e.default=u.exports},nChC:function(t,e){}});
//# sourceMappingURL=17.88bb7d8918ac2c72f7e0.js.map
webpackJsonp([7],{"9lLx":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=a("Xxa5"),r=a.n(s),n=a("exGp"),i=a.n(n),c=a("woOf"),l=a.n(c),o=a("mrNh"),u={name:"course",data:function(){return{pageNum:1,pageSize:10,total:0,editItems:"",loading:!1,academyId:"",name:"",number:"",editVisible:!1,editVisible2:!1,choosed:"未完成课程设计教学",items:[1,1,1],tableData:[]}},mounted:function(){this.Listteacher()},methods:{openLink:function(){this.$router.push({path:"newworks"})},handleEdit:function(e){this.editVisible2=!0,this.editItems=l()({},e)},resetpassword:function(e){var t=this;this.editItems=l()({},e),this.$confirm("确定要重置密码吗？","提示",{type:"warning"}).then(function(){t.modifyteacher(2)}).catch(function(){})},delworks:function(e){var t=this;this.$confirm("确定要删除此教师吗？","提示",{type:"warning"}).then(function(){t.Deleteteacher(e)}).catch(function(){})},changePage:function(e){this.pageNum=e,this.Listteacher()},Addteacher:function(){var e=this;return i()(r.a.mark(function t(){var a,s,n,i,c;return r.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(a=e.number,s=e.name,n=e.academyId,a){t.next=4;break}return e.$message.error("编号不能为空"),t.abrupt("return");case 4:if(s){t.next=8;break}return e.$message.error("姓名不能为空"),t.abrupt("return");case 8:if(n){t.next=12;break}return e.$message.error("学院ID不能为空"),t.abrupt("return");case 12:return i=e.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),t.prev=14,t.next=17,Object(o.f)(a,s,n);case 17:0==(c=t.sent).status.code?(e.$message({message:"添加成功",type:"success"}),e.editVisible=!1,e.Listteacher()):e.$message.error(c.status.description),t.next=24;break;case 21:t.prev=21,t.t0=t.catch(14),console.log(t.t0);case 24:return t.prev=24,i.close(),t.finish(24);case 27:case"end":return t.stop()}},t,e,[[14,21,24,27]])}))()},Listteacher:function(){var e=this;return i()(r.a.mark(function t(){var a,s,n;return r.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return e.loading=!0,a=e.pageNum,s=e.pageSize,t.prev=2,t.next=5,Object(o.v)(a,s);case 5:0==(n=t.sent).status.code?(e.total=n.result.total,e.tableData=n.result.list):e.$message.error(n.status.description),t.next=12;break;case 9:t.prev=9,t.t0=t.catch(2),console.log(t.t0);case 12:return t.prev=12,e.loading=!1,t.finish(12);case 15:case"end":return t.stop()}},t,e,[[2,9,12,15]])}))()},modifyteacher:function(e){var t=this;return i()(r.a.mark(function a(){var s,n,i;return r.a.wrap(function(a){for(;;)switch(a.prev=a.next){case 0:if((s=t.editItems).number){a.next=4;break}return t.$message.error("编号不能为空"),a.abrupt("return");case 4:if(s.name){a.next=8;break}return t.$message.error("姓名不能为空"),a.abrupt("return");case 8:if(s.academyId){a.next=12;break}return t.$message.error("学院ID不能为空"),a.abrupt("return");case 12:if(n=t.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),a.prev=14,1!=e){a.next=21;break}return a.next=18,Object(o.D)(s.id,s.academyId,s.number,s.name);case 18:a.t0=a.sent,a.next=24;break;case 21:return a.next=23,Object(o.D)(s.id,s.academyId,s.number,s.name,123456);case 23:a.t0=a.sent;case 24:0==(i=a.t0).status.code?(1==e?(t.$message({message:"修改成功",type:"success"}),t.editVisible2=!1):t.$message({message:"重置成功，密码123456",type:"success"}),t.Listteacher()):t.$message.error(i.status.description),a.next=31;break;case 28:a.prev=28,a.t1=a.catch(14),console.log(a.t1);case 31:return a.prev=31,n.close(),a.finish(31);case 34:case"end":return a.stop()}},a,t,[[14,28,31,34]])}))()},Deleteteacher:function(e){var t=this;return i()(r.a.mark(function a(){var s,n;return r.a.wrap(function(a){for(;;)switch(a.prev=a.next){case 0:return s=t.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),a.prev=1,a.next=4,Object(o.m)(e);case 4:0==(n=a.sent).status.code?(t.$message({message:"删除成功",type:"success"}),t.Listteacher()):t.$message.error(n.status.description),a.next=11;break;case 8:a.prev=8,a.t0=a.catch(1),console.log(a.t0);case 11:return a.prev=11,s.close(),a.finish(11);case 14:case"end":return a.stop()}},a,t,[[1,8,11,14]])}))()}}},d={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"sworks"},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-lx-calendar"}),e._v(" 教师管理\n            ")])],1)],1),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticClass:"container"},[a("div",{staticClass:"form"},[a("div",{staticClass:"form-top"},[a("el-button",{staticClass:"fr downloadbutton",attrs:{type:"primary",size:"small"}},[e._v("下载用户模板")]),e._v(" "),a("el-button",{staticClass:"fr",attrs:{type:"primary",size:"small"}},[e._v("导入教师用户")]),e._v(" "),a("el-button",{staticClass:"fr",attrs:{type:"primary",size:"small"},on:{click:function(t){e.editVisible=!0}}},[e._v("创建教师用户")])],1),e._v(" "),a("div",{staticClass:"cont"},[a("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:e.tableData}},[a("el-table-column",{attrs:{type:"index",width:"100px",label:"序号"}}),e._v(" "),a("el-table-column",{attrs:{prop:"number",label:"学号"}}),e._v(" "),a("el-table-column",{attrs:{prop:"name",label:"姓名"}}),e._v(" "),a("el-table-column",{attrs:{prop:"academyName",label:"院系"}}),e._v(" "),a("el-table-column",{attrs:{label:"操作",width:"240px"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini"},on:{click:function(a){return e.handleEdit(t.row)}}},[e._v("编辑")]),e._v(" "),a("el-button",{attrs:{size:"mini",type:"info"},on:{click:function(a){return e.resetpassword(t.row)}}},[e._v("重置密码")]),e._v(" "),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){return e.delworks(t.row.id)}}},[e._v("删除")])]}}])})],1),e._v(" "),a("div",{staticClass:"pagination"},[a("el-pagination",{attrs:{background:"","page-size":e.pageSize,layout:"prev, pager, next",total:e.total},on:{"current-change":e.changePage}})],1)],1)])]),e._v(" "),a("el-dialog",{staticClass:"datas-bg",attrs:{title:"创建老师",visible:e.editVisible,width:"380px"},on:{"update:visible":function(t){e.editVisible=t}}},[a("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入老师编号"},model:{value:e.number,callback:function(t){e.number=t},expression:"number"}}),e._v(" "),a("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入老师姓名"},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}}),e._v(" "),a("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入学院ID"},model:{value:e.academyId,callback:function(t){e.academyId=t},expression:"academyId"}}),e._v(" "),a("el-button",{staticStyle:{display:"block",margin:"0 auto"},attrs:{type:"primary",size:"small"},on:{click:e.Addteacher}},[e._v("确 定")])],1),e._v(" "),a("el-dialog",{staticClass:"datas-bg",attrs:{title:"编辑老师",visible:e.editVisible2,width:"380px"},on:{"update:visible":function(t){e.editVisible2=t}}},[a("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入老师编号"},model:{value:e.editItems.number,callback:function(t){e.$set(e.editItems,"number",t)},expression:"editItems.number"}}),e._v(" "),a("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入老师姓名"},model:{value:e.editItems.name,callback:function(t){e.$set(e.editItems,"name",t)},expression:"editItems.name"}}),e._v(" "),a("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入学院ID"},model:{value:e.editItems.academyId,callback:function(t){e.$set(e.editItems,"academyId",t)},expression:"editItems.academyId"}}),e._v(" "),a("el-button",{staticStyle:{display:"block",margin:"0 auto"},attrs:{type:"primary",size:"small"},on:{click:function(t){return e.modifyteacher(1)}}},[e._v("确 定")])],1)],1)},staticRenderFns:[]};var m=a("VU/8")(u,d,!1,function(e){a("FGde"),a("wyRG")},"data-v-5f702296",null);t.default=m.exports},FGde:function(e,t){},wyRG:function(e,t){}});
//# sourceMappingURL=7.498cdc723d01c818d1cd.js.map
webpackJsonp([9],{UYSb:function(e,t){},iH6u:function(e,t){},qwQf:function(e,t,s){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=s("Xxa5"),n=s.n(a),r=s("exGp"),i=s.n(r),c=s("woOf"),o=s.n(c),l=s("mrNh"),u={name:"course",data:function(){return{pageNum:1,pageSize:10,total:0,editItems:"",loading:!1,name:"",number:"",password:"",editVisible:!1,editVisible2:!1,tableData:[]}},mounted:function(){this.Getadminlist()},methods:{openLink:function(){this.$router.push({path:"newworks"})},handleEdit:function(e){this.editVisible2=!0,this.Getadminbyid(e.id)},resetpassword:function(e){var t=this;this.editItems=o()({},e),this.$confirm("确定要重置密码吗？","提示",{type:"warning"}).then(function(){t.Resetadminpassword(e.id)}).catch(function(){})},delworks:function(e){var t=this;this.$confirm("确定要删除此教师吗？","提示",{type:"warning"}).then(function(){t.Deleteadmin(e)}).catch(function(){})},changePage:function(e){this.pageNum=e,this.Getadminlist()},Addadmin:function(){var e=this;return i()(n.a.mark(function t(){var s,a,r,i,c;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(s=e.number,a=e.name,r=e.password,s){t.next=4;break}return e.$message.error("编号不能为空"),t.abrupt("return");case 4:if(a){t.next=8;break}return e.$message.error("姓名不能为空"),t.abrupt("return");case 8:if(r){t.next=12;break}return e.$message.error("密码不能为空"),t.abrupt("return");case 12:return i=e.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),t.prev=14,t.next=17,Object(l.b)(s,a,r);case 17:0==(c=t.sent).status.code?(e.$message({message:"添加成功",type:"success"}),e.editVisible=!1,e.Getadminlist()):e.$message.error(c.status.description),t.next=24;break;case 21:t.prev=21,t.t0=t.catch(14),console.log(t.t0);case 24:return t.prev=24,i.close(),t.finish(24);case 27:case"end":return t.stop()}},t,e,[[14,21,24,27]])}))()},Getadminlist:function(){var e=this;return i()(n.a.mark(function t(){var s,a,r;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return e.loading=!0,s=e.pageNum,a=e.pageSize,t.prev=2,t.next=5,Object(l.p)(s,a);case 5:0==(r=t.sent).status.code?(e.total=r.result.total,e.tableData=r.result.list):e.$message.error(r.status.description),t.next=12;break;case 9:t.prev=9,t.t0=t.catch(2),console.log(t.t0);case 12:return t.prev=12,e.loading=!1,t.finish(12);case 15:case"end":return t.stop()}},t,e,[[2,9,12,15]])}))()},Updateadmin:function(){var e=this;return i()(n.a.mark(function t(){var s,a,r;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if((s=e.editItems).number){t.next=4;break}return e.$message.error("编号不能为空"),t.abrupt("return");case 4:if(s.name){t.next=8;break}return e.$message.error("姓名不能为空"),t.abrupt("return");case 8:if(s.password){t.next=12;break}return e.$message.error("密码不能为空"),t.abrupt("return");case 12:return a=e.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),t.prev=14,t.next=17,Object(l.A)(s.id,s.number,s.name,s.password);case 17:0==(r=t.sent).status.code?(e.$message({message:"修改成功",type:"success"}),e.editVisible2=!1,e.Getadminlist()):e.$message.error(r.status.description),t.next=24;break;case 21:t.prev=21,t.t0=t.catch(14),console.log(t.t0);case 24:return t.prev=24,a.close(),t.finish(24);case 27:case"end":return t.stop()}},t,e,[[14,21,24,27]])}))()},Resetadminpassword:function(e){var t=this;return i()(n.a.mark(function s(){var a,r;return n.a.wrap(function(s){for(;;)switch(s.prev=s.next){case 0:return a=t.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),s.prev=1,s.next=4,Object(l.y)(e);case 4:0==(r=s.sent).status.code?t.$message({message:"修改成功",type:"success"}):t.$message.error(r.status.description),s.next=11;break;case 8:s.prev=8,s.t0=s.catch(1),console.log(s.t0);case 11:return s.prev=11,a.close(),s.finish(11);case 14:case"end":return s.stop()}},s,t,[[1,8,11,14]])}))()},Deleteadmin:function(e){var t=this;return i()(n.a.mark(function s(){var a,r;return n.a.wrap(function(s){for(;;)switch(s.prev=s.next){case 0:return a=t.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),s.prev=1,s.next=4,Object(l.i)(e);case 4:0==(r=s.sent).status.code?(t.$message({message:"删除成功",type:"success"}),t.Getadminlist()):t.$message.error(r.status.description),s.next=11;break;case 8:s.prev=8,s.t0=s.catch(1),console.log(s.t0);case 11:return s.prev=11,a.close(),s.finish(11);case 14:case"end":return s.stop()}},s,t,[[1,8,11,14]])}))()},Getadminbyid:function(e){var t=this;return i()(n.a.mark(function s(){var a,r;return n.a.wrap(function(s){for(;;)switch(s.prev=s.next){case 0:return a=t.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),s.prev=1,s.next=4,Object(l.o)(e);case 4:0==(r=s.sent).status.code?t.editItems=r.result:t.$message.error(r.status.description),s.next=11;break;case 8:s.prev=8,s.t0=s.catch(1),console.log(s.t0);case 11:return s.prev=11,a.close(),s.finish(11);case 14:case"end":return s.stop()}},s,t,[[1,8,11,14]])}))()}}},d={render:function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"sworks"},[s("div",{staticClass:"crumbs"},[s("el-breadcrumb",{attrs:{separator:"/"}},[s("el-breadcrumb-item",[s("i",{staticClass:"el-icon-lx-calendar"}),e._v(" 管理员管理\n            ")])],1)],1),e._v(" "),s("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticClass:"container"},[s("div",{staticClass:"form"},[s("div",{staticClass:"form-top"},[s("el-button",{staticClass:"fr",attrs:{type:"primary",size:"small"},on:{click:function(t){e.editVisible=!0}}},[e._v("创建管理员用户")])],1),e._v(" "),s("div",{staticClass:"cont"},[s("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:e.tableData}},[s("el-table-column",{attrs:{type:"index",width:"100px",label:"序号"}}),e._v(" "),s("el-table-column",{attrs:{prop:"number",label:"编号"}}),e._v(" "),s("el-table-column",{attrs:{prop:"name",label:"姓名"}}),e._v(" "),s("el-table-column",{attrs:{label:"操作",width:"250px"},scopedSlots:e._u([{key:"default",fn:function(t){return[s("el-button",{attrs:{size:"mini"},on:{click:function(s){return e.handleEdit(t.row)}}},[e._v("编辑")]),e._v(" "),s("el-button",{attrs:{size:"mini",type:"info"},on:{click:function(s){return e.resetpassword(t.row)}}},[e._v("重置密码")]),e._v(" "),s("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(s){return e.delworks(t.row.id)}}},[e._v("删除")])]}}])})],1),e._v(" "),s("div",{staticClass:"pagination"},[s("el-pagination",{attrs:{background:"","page-size":e.pageSize,layout:"prev, pager, next",total:e.total},on:{"current-change":e.changePage}})],1)],1)])]),e._v(" "),s("el-dialog",{staticClass:"datas-bg",attrs:{title:"创建管理员",visible:e.editVisible,width:"380px"},on:{"update:visible":function(t){e.editVisible=t}}},[s("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入管理员编号"},model:{value:e.number,callback:function(t){e.number=t},expression:"number"}}),e._v(" "),s("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入管理员姓名"},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}}),e._v(" "),s("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入管理员密码"},model:{value:e.password,callback:function(t){e.password=t},expression:"password"}}),e._v(" "),s("el-button",{staticStyle:{display:"block",margin:"0 auto"},attrs:{type:"primary",size:"small"},on:{click:e.Addadmin}},[e._v("确 定")])],1),e._v(" "),s("el-dialog",{staticClass:"datas-bg",attrs:{title:"编辑管理员",visible:e.editVisible2,width:"380px"},on:{"update:visible":function(t){e.editVisible2=t}}},[s("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入管理员编号"},model:{value:e.editItems.number,callback:function(t){e.$set(e.editItems,"number",t)},expression:"editItems.number"}}),e._v(" "),s("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入管理员姓名"},model:{value:e.editItems.name,callback:function(t){e.$set(e.editItems,"name",t)},expression:"editItems.name"}}),e._v(" "),s("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入管理员密码"},model:{value:e.editItems.password,callback:function(t){e.$set(e.editItems,"password",t)},expression:"editItems.password"}}),e._v(" "),s("el-button",{staticStyle:{display:"block",margin:"0 auto"},attrs:{type:"primary",size:"small"},on:{click:e.Updateadmin}},[e._v("确 定")])],1)],1)},staticRenderFns:[]};var p=s("VU/8")(u,d,!1,function(e){s("UYSb"),s("iH6u")},"data-v-26c91eee",null);t.default=p.exports}});
//# sourceMappingURL=9.99f1710df2764ba5fea6.js.map
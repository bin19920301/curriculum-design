webpackJsonp([10],{"/h0v":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=a("Xxa5"),n=a.n(s),r=a("exGp"),l=a.n(r),i=a("mrNh"),c={name:"course",data:function(){return{editVisible:!1,editVisible1:!1,pageNum:1,pageSize:10,total:0,loading:!1,allenrollmentYear:[],enrollmentId:"",allacademy:[],academyId:"",allclass:[],classId:"",classId2:"",number:"",name:"",id:"",editItems:"",tableData:[]}},mounted:function(){this.Liststudent(),this.Listallenrollmentyear(),this.Getallacademylist()},methods:{openLink:function(){this.$router.push({path:"newworks"})},handleEdit:function(e){this.editVisible1=!0,this.number=e.number,this.name=e.name,this.enrollmentId=e.enrollmentId,this.academyId=e.academyId,this.classId2=e.classId,this.id=e.id,this.Getclassbyacademyid()},delworks:function(e){var t=this;this.$confirm("确定要删除吗？","提示",{type:"warning"}).then(function(){t.Deletestudent(e)}).catch(function(){})},changePage:function(e){this.pageNum=e,this.Liststudent()},newstudent:function(){this.editVisible=!0,this.number="",this.name="",this.enrollmentId="",this.academyId="",this.classId2="",this.classId=""},Liststudent:function(){var e=this;return l()(n.a.mark(function t(){var a,s,r;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return e.loading=!0,a=e.pageNum,s=e.pageSize,t.prev=2,t.next=5,Object(i.X)(a,s);case 5:0==(r=t.sent).status.code?(e.total=r.result.total,e.tableData=r.result.list):e.$message.error(r.status.description),t.next=12;break;case 9:t.prev=9,t.t0=t.catch(2),console.log(t.t0);case 12:return t.prev=12,e.loading=!1,t.finish(12);case 15:case"end":return t.stop()}},t,e,[[2,9,12,15]])}))()},Updatestudent:function(){var e=this;return l()(n.a.mark(function t(){var a,s,r,l,c,o,u,d;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(a=e.number,s=e.name,r=e.academyId,l=e.enrollmentId,c=e.classId,o=e.id,a){t.next=4;break}return e.$message.error("学号不能为空"),t.abrupt("return");case 4:if(s){t.next=8;break}return e.$message.error("姓名不能为空"),t.abrupt("return");case 8:if(r){t.next=12;break}return e.$message.error("请选择入学年份"),t.abrupt("return");case 12:if(l){t.next=16;break}return e.$message.error("请选择院系"),t.abrupt("return");case 16:if(c&&"该学院下暂无班级"!=c){t.next=20;break}return e.$message.error("请选择班级"),t.abrupt("return");case 20:return u=e.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),t.prev=22,t.next=25,Object(i._14)(o,a,s,r,l,c);case 25:0==(d=t.sent).status.code?(e.$message({message:"修改成功",type:"success"}),e.editVisible1=!1,e.Liststudent()):e.$message.error(d.status.description),t.next=32;break;case 29:t.prev=29,t.t0=t.catch(22),console.log(t.t0);case 32:return t.prev=32,u.close(),t.finish(32);case 35:case"end":return t.stop()}},t,e,[[22,29,32,35]])}))()},Addstudent:function(){var e=this;return l()(n.a.mark(function t(){var a,s,r,l,c,o,u;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(a=e.number,s=e.name,r=e.academyId,l=e.enrollmentId,c=e.classId,a){t.next=4;break}return e.$message.error("学号不能为空"),t.abrupt("return");case 4:if(s){t.next=8;break}return e.$message.error("姓名不能为空"),t.abrupt("return");case 8:if(r){t.next=12;break}return e.$message.error("请选择入学年份"),t.abrupt("return");case 12:if(l){t.next=16;break}return e.$message.error("请选择院系"),t.abrupt("return");case 16:if(c&&"该学院下暂无班级"!=c){t.next=20;break}return e.$message.error("请选择班级"),t.abrupt("return");case 20:return o=e.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),t.prev=22,t.next=25,Object(i.i)(a,s,r,l,c);case 25:0==(u=t.sent).status.code?(e.$message({message:"添加成功",type:"success"}),e.editVisible=!1,e.Liststudent()):e.$message.error(u.status.description),t.next=32;break;case 29:t.prev=29,t.t0=t.catch(22),console.log(t.t0);case 32:return t.prev=32,o.close(),t.finish(32);case 35:case"end":return t.stop()}},t,e,[[22,29,32,35]])}))()},Deletestudent:function(e){var t=this;return l()(n.a.mark(function a(){var s,r;return n.a.wrap(function(a){for(;;)switch(a.prev=a.next){case 0:return s=t.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),a.prev=1,a.next=4,Object(i.x)(e);case 4:0==(r=a.sent).status.code?(t.$message({message:"删除成功",type:"success"}),t.Liststudent()):t.$message.error(r.status.description),a.next=11;break;case 8:a.prev=8,a.t0=a.catch(1),console.log(a.t0);case 11:return a.prev=11,s.close(),a.finish(11);case 14:case"end":return a.stop()}},a,t,[[1,8,11,14]])}))()},Listallenrollmentyear:function(){var e=this;return l()(n.a.mark(function t(){var a;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,Object(i.U)();case 3:0==(a=t.sent).status.code?e.allenrollmentYear=a.result.list:e.$message.error(a.status.description),t.next=10;break;case 7:t.prev=7,t.t0=t.catch(0),console.log(t.t0);case 10:return t.prev=10,e.loading=!1,t.finish(10);case 13:case"end":return t.stop()}},t,e,[[0,7,10,13]])}))()},Getallacademylist:function(){var e=this;return l()(n.a.mark(function t(){var a;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,Object(i.H)();case 3:0==(a=t.sent).status.code?e.allacademy=a.result.list:e.$message.error(a.status.description),t.next=10;break;case 7:t.prev=7,t.t0=t.catch(0),console.log(t.t0);case 10:return t.prev=10,e.loading=!1,t.finish(10);case 13:case"end":return t.stop()}},t,e,[[0,7,10,13]])}))()},Getclassbyacademyid:function(){var e=this;return l()(n.a.mark(function t(){var a;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,Object(i.K)(e.academyId);case 3:0==(a=t.sent).status.code?(0==a.result.list.length?e.classId2="该学院下暂无班级":(e.classId="","该学院下暂无班级"==e.classId2&&(e.classId2="")),e.allclass=a.result.list,e.classId=e.classId2):e.$message.error(a.status.description),t.next=10;break;case 7:t.prev=7,t.t0=t.catch(0),console.log(t.t0);case 10:return t.prev=10,e.loading=!1,t.finish(10);case 13:case"end":return t.stop()}},t,e,[[0,7,10,13]])}))()}}},o={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"sworks"},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-lx-calendar"}),e._v(" 学生管理\n            ")])],1)],1),e._v(" "),a("div",{staticClass:"container"},[a("div",{staticClass:"form"},[a("div",{staticClass:"form-top"},[a("el-button",{staticClass:"fr downloadbutton",attrs:{type:"primary",size:"small"}},[e._v("下载用户模板")]),e._v(" "),a("el-button",{staticClass:"fr",attrs:{type:"primary",size:"small"}},[e._v("导入学生用户")]),e._v(" "),a("el-button",{staticClass:"fr",attrs:{type:"primary",size:"small"},on:{click:e.newstudent}},[e._v("创建学生用户")])],1),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticClass:"cont"},[a("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:e.tableData}},[a("el-table-column",{attrs:{type:"index",width:"100px",label:"序号"}}),e._v(" "),a("el-table-column",{attrs:{prop:"number",label:"学号"}}),e._v(" "),a("el-table-column",{attrs:{prop:"name",label:"姓名"}}),e._v(" "),a("el-table-column",{attrs:{prop:"enrollmentYear",label:"入学年份"}}),e._v(" "),a("el-table-column",{attrs:{prop:"academyName",label:"院系"}}),e._v(" "),a("el-table-column",{attrs:{prop:"className",label:"班级"}}),e._v(" "),a("el-table-column",{attrs:{label:"操作",width:"150px"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini"},on:{click:function(a){return e.handleEdit(t.row)}}},[e._v("编辑")]),e._v(" "),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){return e.delworks(t.row.id)}}},[e._v("删除")])]}}])})],1),e._v(" "),a("div",{staticClass:"pagination"},[a("el-pagination",{attrs:{background:"","page-size":e.pageSize,layout:"prev, pager, next",total:e.total},on:{"current-change":e.changePage}})],1)],1)])]),e._v(" "),a("el-dialog",{staticClass:"datas-bg",attrs:{title:"添加学生",visible:e.editVisible,width:"380px"},on:{"update:visible":function(t){e.editVisible=t}}},[a("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入学号"},model:{value:e.number,callback:function(t){e.number=t},expression:"number"}}),e._v(" "),a("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入姓名"},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}}),e._v(" "),a("el-select",{staticClass:"margin10",attrs:{size:"small",placeholder:"请选择入学年份"},model:{value:e.enrollmentId,callback:function(t){e.enrollmentId=t},expression:"enrollmentId"}},e._l(e.allenrollmentYear,function(e){return a("el-option",{key:e.id,attrs:{label:e.enrollmentYear,value:e.id}})}),1),a("br"),e._v(" "),a("el-select",{staticClass:"margin10",attrs:{size:"small",placeholder:"请选择院系"},on:{change:function(t){return e.Getclassbyacademyid()}},model:{value:e.academyId,callback:function(t){e.academyId=t},expression:"academyId"}},e._l(e.allacademy,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}),1),a("br"),e._v(" "),a("el-select",{staticClass:"margin10",attrs:{disabled:0==e.allclass.length,size:"small",placeholder:"请选择班级"},model:{value:e.classId,callback:function(t){e.classId=t},expression:"classId"}},e._l(e.allclass,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}),1),a("br"),e._v(" "),a("el-button",{staticStyle:{display:"block",margin:"0 auto"},attrs:{type:"primary",size:"small"},on:{click:e.Addstudent}},[e._v("确 定")])],1),e._v(" "),a("el-dialog",{staticClass:"datas-bg",attrs:{title:"编辑学生",visible:e.editVisible1,width:"380px"},on:{"update:visible":function(t){e.editVisible1=t}}},[a("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入学号"},model:{value:e.number,callback:function(t){e.number=t},expression:"number"}}),e._v(" "),a("el-input",{staticClass:"margin10",attrs:{size:"small",placeholder:"请输入姓名"},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}}),e._v(" "),a("el-select",{staticClass:"margin10",attrs:{size:"small",placeholder:"请选择入学年份"},model:{value:e.enrollmentId,callback:function(t){e.enrollmentId=t},expression:"enrollmentId"}},e._l(e.allenrollmentYear,function(e){return a("el-option",{key:e.id,attrs:{label:e.enrollmentYear,value:e.id}})}),1),a("br"),e._v(" "),a("el-select",{staticClass:"margin10",attrs:{size:"small",placeholder:"请选择院系"},on:{change:function(t){return e.Getclassbyacademyid()}},model:{value:e.academyId,callback:function(t){e.academyId=t},expression:"academyId"}},e._l(e.allacademy,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}),1),a("br"),e._v(" "),a("el-select",{staticClass:"margin10",attrs:{disabled:0==e.allclass.length,size:"small",placeholder:"请选择班级"},model:{value:e.classId,callback:function(t){e.classId=t},expression:"classId"}},e._l(e.allclass,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}),1),a("br"),e._v(" "),a("el-button",{staticStyle:{display:"block",margin:"0 auto"},attrs:{type:"primary",size:"small"},on:{click:e.Updatestudent}},[e._v("确 定")])],1)],1)},staticRenderFns:[]};var u=a("VU/8")(c,o,!1,function(e){a("ncGU"),a("xEzE")},"data-v-4773d3ea",null);t.default=u.exports},ncGU:function(e,t){},xEzE:function(e,t){}});
//# sourceMappingURL=10.7cd9ed951d2a61a5feab.js.map
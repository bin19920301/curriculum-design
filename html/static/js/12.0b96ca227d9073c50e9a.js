webpackJsonp([12],{"/f4X":function(e,t){},D1k3:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=a("Xxa5"),n=a.n(s),r=a("exGp"),i=a.n(r),l=a("mrNh"),o={name:"course",data:function(){return{id:"",loading:!1,name:"",deadlineTime:"",teacherReminder:"",workForTeacherDTOList:[],options1:[{id:"",enrollmentYear:"全部年份"}],options2:[{id:"",name:"全部院系",classList:[]}],options3:[{id:"",name:"全部班级"}],select1:"",select2:"",select3:"",studentlist:[],editVisible:!1,checked:!1,changestu:[],options:[]}},mounted:function(){var e=this.$route.params.pid;this.id=e,this.Getallworkprojectlist(),-1!=e&&this.fetchGetteachingbyId(),this.Listallenrollmentyear(),this.Getallacademylist()},methods:{handleEdit:function(e,t){console.log(e,t)},handleSelectionChange:function(e){this.changestu=e},handleDelete:function(e,t){this.workForTeacherDTOList.splice(e,1)},modifyStuList:function(){this.editVisible=!0,this.Liststudentbyparam()},substudent:function(){var e=this.changestu.map(function(e){return{academyName:e.academyName,className:e.className,enrollmentYear:e.enrollmentYear,studentId:e.id,studentName:e.name,studentNumber:e.number,workProjectId:"",workProjectName:""}});this.workForTeacherDTOList=this.workForTeacherDTOList.concat(e),this.editVisible=!1},savechange:function(){-1==this.id?this.Addteaching():this.Updateteaching()},Updateteaching:function(){var e=this;return i()(n.a.mark(function t(){var a,s,r,i,o,c,u,d;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(a=e.id,s=e.name,r=e.teacherReminder,i=e.deadlineTime,o=e.workForTeacherDTOList,c=!1,o.forEach(function(t){if(""==t.workProjectId)return e.$message({message:"请为"+t.studentName+"选择作业项目",type:"warning"}),void(c=!0)}),!c){t.next=5;break}return t.abrupt("return");case 5:return e.loading=!0,u=o.map(function(e){return{workStudentId:e.studentId,workProjectId:e.workProjectId}}),t.prev=8,t.next=11,Object(l._10)(a,s,r,e.$timeChange(i),u);case 11:0==(d=t.sent).status.code?e.$message({message:"课程设计教学修改成功",type:"success"}):e.$message.error(d.status.description),t.next=18;break;case 15:t.prev=15,t.t0=t.catch(8),console.log(t.t0);case 18:return t.prev=18,e.loading=!1,t.finish(18);case 21:case"end":return t.stop()}},t,e,[[8,15,18,21]])}))()},Addteaching:function(){var e=this;return i()(n.a.mark(function t(){var a,s,r,i,o,c,u;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(a=e.name,s=e.teacherReminder,r=e.deadlineTime,i=e.workForTeacherDTOList,o=!1,i.forEach(function(t){if(""==t.workProjectId)return e.$message({message:"请为"+t.studentName+"选择作业项目",type:"warning"}),void(o=!0)}),!o){t.next=5;break}return t.abrupt("return");case 5:return e.loading=!0,c=i.map(function(e){return{workStudentId:e.studentId,workProjectId:e.workProjectId}}),t.prev=8,t.next=11,Object(l.k)(a,s,e.$timeChange(r),c);case 11:0==(u=t.sent).status.code?e.$message({message:"课程设计教学创建成功",type:"success"}):e.$message.error(u.status.description),t.next=18;break;case 15:t.prev=15,t.t0=t.catch(8),console.log(t.t0);case 18:return t.prev=18,e.loading=!1,t.finish(18);case 21:case"end":return t.stop()}},t,e,[[8,15,18,21]])}))()},fetchGetteachingbyId:function(){var e=this;return i()(n.a.mark(function t(){var a,s;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return e.loading=!0,a=e.id,t.prev=2,t.next=5,Object(l.M)(a);case 5:0==(s=t.sent).status.code?(e.name=s.result.name,e.deadlineTime=s.result.deadlineTime,e.teacherReminder=s.result.teacherReminder,e.workForTeacherDTOList=s.result.workForTeacherDTOList):e.$message.error(s.status.description),t.next=12;break;case 9:t.prev=9,t.t0=t.catch(2),console.log(t.t0);case 12:return t.prev=12,e.loading=!1,t.finish(12);case 15:case"end":return t.stop()}},t,e,[[2,9,12,15]])}))()},change2:function(e){this.select3="";var t=this.options2.filter(function(t){return t.id==e});this.options3=[{id:"",name:"全部班级"}].concat(t[0].classList),this.Liststudentbyparam()},Listallenrollmentyear:function(){var e=this;return i()(n.a.mark(function t(){var a;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return e.id,t.prev=1,t.next=4,Object(l.S)();case 4:0==(a=t.sent).status.code?e.options1=e.options1.concat(a.result.list):e.$message.error(a.status.description),t.next=11;break;case 8:t.prev=8,t.t0=t.catch(1),console.log(t.t0);case 11:return t.prev=11,t.finish(11);case 13:case"end":return t.stop()}},t,e,[[1,8,11,13]])}))()},Getallacademylist:function(){var e=this;return i()(n.a.mark(function t(){var a;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return e.id,t.prev=1,t.next=4,Object(l.D)();case 4:0==(a=t.sent).status.code?e.options2=e.options2.concat(a.result.list):e.$message.error(a.status.description),t.next=11;break;case 8:t.prev=8,t.t0=t.catch(1),console.log(t.t0);case 11:return t.prev=11,t.finish(11);case 13:case"end":return t.stop()}},t,e,[[1,8,11,13]])}))()},Liststudentbyparam:function(){var e=this;return i()(n.a.mark(function t(){var a,s,r,i;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return a=e.select1,s=e.select2,r=e.select3,t.prev=1,t.next=4,Object(l.W)(a,s,r);case 4:0==(i=t.sent).status.code?(e.studentlist=i.result.list,e.changestu=[]):e.$message.error(i.status.description),t.next=11;break;case 8:t.prev=8,t.t0=t.catch(1),console.log(t.t0);case 11:return t.prev=11,t.finish(11);case 13:case"end":return t.stop()}},t,e,[[1,8,11,13]])}))()},Getallworkprojectlist:function(){var e=this;return i()(n.a.mark(function t(){var a;return n.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,Object(l.H)();case 3:0==(a=t.sent).status.code?e.options=a.result.list:e.$message.error(a.status.description),t.next=10;break;case 7:t.prev=7,t.t0=t.catch(0),console.log(t.t0);case 10:return t.prev=10,t.finish(10);case 12:case"end":return t.stop()}},t,e,[[0,7,10,12]])}))()}}},c={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"newcourse"},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-lx-calendar"}),e._v(" 课程设计\n            ")]),e._v(" "),a("el-breadcrumb-item",[e._v(e._s(-1==e.id?"新建课程设计教学":"编辑课程设计教学"))])],1)],1),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticClass:"container"},[a("div",{staticClass:"form"},[a("el-form",{attrs:{"label-width":"110px"}},[a("el-form-item",{attrs:{label:"教学名称："}},[a("el-input",{attrs:{size:"small"},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}})],1),e._v(" "),a("el-form-item",{attrs:{size:"small",label:"作业提交截止："}},[a("el-col",{attrs:{span:11}},[a("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"date",placeholder:"选择日期","value-format":"yyyy-MM-dd"},model:{value:e.deadlineTime,callback:function(t){e.deadlineTime=t},expression:"deadlineTime"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"教师提示："}},[a("el-input",{attrs:{size:"small",type:"textarea",rows:"5"},model:{value:e.teacherReminder,callback:function(t){e.teacherReminder=t},expression:"teacherReminder"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"学生名单："}},[a("el-table",{staticClass:"stu-list",staticStyle:{width:"100%"},attrs:{size:"mini",height:"330",data:e.workForTeacherDTOList}},[a("el-table-column",{attrs:{type:"index",label:"序号"}}),e._v(" "),a("el-table-column",{attrs:{label:"姓名"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.studentName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"入学年份"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.enrollmentYear))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"学号"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.studentNumber))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"院系"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.academyName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"班级"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.className))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"作业项目"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-select",{attrs:{size:"mini",value:t.row.workProjectName,placeholder:"请选择"},model:{value:t.row.workProjectId,callback:function(a){e.$set(t.row,"workProjectId",a)},expression:"scope.row.workProjectId"}},e._l(e.options,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}),1)]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作",width:"80px"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){return e.handleDelete(t.$index,t.row)}}},[e._v("删除")])]}}])})],1),e._v(" "),a("div",{staticClass:"stunumber"},[a("span",[e._v("共计 "+e._s(e.workForTeacherDTOList.length)+" 人")]),e._v(" "),a("el-button",{attrs:{type:"primary",size:"mini",plain:""},on:{click:e.modifyStuList}},[e._v("修改名单")])],1)],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.savechange}},[e._v(e._s(-1==e.id?"创建教学":"确定修改"))])],1)],1)],1)]),e._v(" "),a("el-dialog",{attrs:{title:"修改学生名单",visible:e.editVisible,width:"800px"},on:{"update:visible":function(t){e.editVisible=t}}},[a("div",{staticClass:"select-bg"},[a("el-select",{attrs:{size:"small",placeholder:"请选择"},on:{change:e.Liststudentbyparam},model:{value:e.select1,callback:function(t){e.select1=t},expression:"select1"}},e._l(e.options1,function(e){return a("el-option",{key:e.id,attrs:{label:e.enrollmentYear,value:e.id}})}),1),e._v(" "),a("el-select",{attrs:{size:"small",placeholder:"请选择"},on:{change:e.change2},model:{value:e.select2,callback:function(t){e.select2=t},expression:"select2"}},e._l(e.options2,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}),1),e._v(" "),a("el-select",{attrs:{size:"small",placeholder:"请选择"},on:{change:e.Liststudentbyparam},model:{value:e.select3,callback:function(t){e.select3=t},expression:"select3"}},e._l(e.options3,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}),1)],1),e._v(" "),a("el-table",{ref:"multipleTable",staticClass:"editlist",staticStyle:{width:"100%"},attrs:{size:"mini",data:e.studentlist,"tooltip-effect":"dark",height:"300px"},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection"}}),e._v(" "),a("el-table-column",{attrs:{type:"index",label:"序号"}}),e._v(" "),a("el-table-column",{attrs:{prop:"name",label:"姓名"}}),e._v(" "),a("el-table-column",{attrs:{prop:"enrollmentYear",label:"入学年份"}}),e._v(" "),a("el-table-column",{attrs:{prop:"number",label:"学号"}}),e._v(" "),a("el-table-column",{attrs:{prop:"academyName",label:"院系"}}),e._v(" "),a("el-table-column",{attrs:{prop:"className",label:"班级"}})],1),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-checkbox",{staticClass:"fl",model:{value:e.checked,callback:function(t){e.checked=t},expression:"checked"}},[e._v("随机布置作业")]),e._v(" "),a("el-button",{attrs:{size:"small"},on:{click:function(t){e.editVisible=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.substudent}},[e._v("确 定")])],1)],1)],1)},staticRenderFns:[]};var u=a("VU/8")(o,c,!1,function(e){a("sAyM"),a("/f4X")},"data-v-31d37fbe",null);t.default=u.exports},sAyM:function(e,t){}});
//# sourceMappingURL=12.0b96ca227d9073c50e9a.js.map
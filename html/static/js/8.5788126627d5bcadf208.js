webpackJsonp([8],{"PQ+j":function(e,t,s){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=s("Xxa5"),r=s.n(a),n=s("exGp"),i=s.n(n),o=s("mrNh"),l=s("eOoE"),c={name:"course",data:function(){return{text:"新建作业项目",types:"",loading:!1,loading1:!1,editVisible:!1,checked:!1,tableData:[],options:[],value:"",fileIdList:[],answerList:[],chooselist:[],type:0,name:"",desc:"",downurls:""}},mounted:function(){this.downurls=l.a;var e=this.$route.params.type;this.types=e,this.Getallfolder(),0!=e&&(this.Getworkprojectinfo(e),this.text="编辑作业项目")},methods:{handleEdit:function(e,t){console.log(e,t)},handleSelectionChange:function(e){this.chooselist=e},savechoose:function(){if(0==this.type){var e=this.chooselist.concat(this.fileIdList),t=e.filter(function(t,s,a){var r=[];return e.forEach(function(e,t){r.push(e.id)}),r.indexOf(t.id)===s});this.fileIdList=t}else{var s=this.chooselist.concat(this.answerList);t=s.filter(function(e,t,a){var r=[];return s.forEach(function(e,t){r.push(e.id)}),r.indexOf(e.id)===t});this.answerList=t}this.chooselist=[],this.editVisible=!1},deldataone:function(e,t){0==e?this.fileIdList.splice(t,1):this.answerList.splice(t,1)},modifyStuList:function(e){this.editVisible=!0,this.type=e},savedata:function(){0==this.types?this.Addworkproject():this.Updateworkproject()},Updateworkproject:function(){var e=this;return i()(r.a.mark(function t(){var s,a,n,i,l,c,u,d,p;return r.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(s=e.types,a=e.name,n=e.desc,i=e.fileIdList,l=e.answerList,a){t.next=4;break}return e.$message.error("作业名称不能为空"),t.abrupt("return");case 4:if(n){t.next=8;break}return e.$message.error("简介不能为空"),t.abrupt("return");case 8:if(0!=i.length){t.next=12;break}return e.$message.error("资料不能为空"),t.abrupt("return");case 12:if(0!=l.length){t.next=16;break}return e.$message.error("参考答案不能为空"),t.abrupt("return");case 16:return c=String(i.map(function(e){return e.id})),u=String(l.map(function(e){return e.id})),d=e.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),t.prev=20,t.next=23,Object(o._17)(s,a,n,c,u);case 23:0==(p=t.sent).status.code?e.$message({message:"修改成功",type:"success"}):e.$message.error(p.status.description),t.next=30;break;case 27:t.prev=27,t.t0=t.catch(20),console.log(t.t0);case 30:return t.prev=30,d.close(),t.finish(30);case 33:case"end":return t.stop()}},t,e,[[20,27,30,33]])}))()},Addworkproject:function(){var e=this;return i()(r.a.mark(function t(){var s,a,n,i,l,c,u,d;return r.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(s=e.name,a=e.desc,n=e.fileIdList,i=e.answerList,s){t.next=4;break}return e.$message.error("作业名称不能为空"),t.abrupt("return");case 4:if(a){t.next=8;break}return e.$message.error("简介不能为空"),t.abrupt("return");case 8:if(0!=n.length){t.next=12;break}return e.$message.error("资料不能为空"),t.abrupt("return");case 12:if(0!=i.length){t.next=16;break}return e.$message.error("参考答案不能为空"),t.abrupt("return");case 16:return l=String(n.map(function(e){return e.id})),c=String(i.map(function(e){return e.id})),u=e.$loading({lock:!0,text:"加载中...",spinner:"el-icon-loading"}),t.prev=20,t.next=23,Object(o.n)(s,a,l,c);case 23:0==(d=t.sent).status.code?e.$message({message:"添加成功",type:"success"}):e.$message.error(d.status.description),t.next=30;break;case 27:t.prev=27,t.t0=t.catch(20),console.log(t.t0);case 30:return t.prev=30,u.close(),t.finish(30);case 33:case"end":return t.stop()}},t,e,[[20,27,30,33]])}))()},GetFileByFolderId:function(e){var t=this;return i()(r.a.mark(function s(){var a;return r.a.wrap(function(s){for(;;)switch(s.prev=s.next){case 0:return t.loading=!0,s.prev=1,s.next=4,Object(o.D)(t.pageNum,t.pageSize,e);case 4:0==(a=s.sent).status.code?t.tableData=a.result.list:t.$message.error(a.status.description),s.next=11;break;case 8:s.prev=8,s.t0=s.catch(1),console.log(s.t0);case 11:return s.prev=11,t.loading=!1,s.finish(11);case 14:case"end":return s.stop()}},s,t,[[1,8,11,14]])}))()},Getworkprojectinfo:function(e){var t=this;return i()(r.a.mark(function s(){var a;return r.a.wrap(function(s){for(;;)switch(s.prev=s.next){case 0:return t.loading1=!0,s.prev=1,s.next=4,Object(o.S)(e);case 4:0==(a=s.sent).status.code?(t.name=a.result.name,t.desc=a.result.desc,t.fileIdList=a.result.filelist,t.answerList=a.result.referenceSolutionList):t.$message.error(a.status.description),s.next=11;break;case 8:s.prev=8,s.t0=s.catch(1),console.log(s.t0);case 11:return s.prev=11,t.loading1=!1,s.finish(11);case 14:case"end":return s.stop()}},s,t,[[1,8,11,14]])}))()},Getallfolder:function(){var e=this;return i()(r.a.mark(function t(){var s;return r.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return e.loading=!0,t.prev=1,t.next=4,Object(o.I)();case 4:0==(s=t.sent).status.code?e.options=s.result.list:e.$message.error(s.status.description),t.next=11;break;case 8:t.prev=8,t.t0=t.catch(1),console.log(t.t0);case 11:return t.prev=11,e.loading=!1,t.finish(11);case 14:case"end":return t.stop()}},t,e,[[1,8,11,14]])}))()}}},u={render:function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"newworks"},[s("div",{staticClass:"crumbs"},[s("el-breadcrumb",{attrs:{separator:"/"}},[s("el-breadcrumb-item",[s("i",{staticClass:"el-icon-lx-calendar"}),e._v(" 作业项目\n            ")]),e._v(" "),s("el-breadcrumb-item",[e._v(e._s(e.text))])],1)],1),e._v(" "),s("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading1,expression:"loading1"}],staticClass:"container"},[s("div",{staticClass:"form"},[s("el-form",{ref:"form",attrs:{"label-width":"110px"}},[s("el-form-item",{attrs:{label:"作业名称："}},[s("el-input",{attrs:{size:"small"},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"简介："}},[s("el-input",{attrs:{size:"small",type:"textarea",rows:"5"},model:{value:e.desc,callback:function(t){e.desc=t},expression:"desc"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"资料："}},[s("div",{staticClass:"data-out"},[e._l(e.fileIdList,function(t,a){return s("p",{staticClass:"data-bg"},[s("a",{attrs:{target:"_blank",href:e.downurls+t.url}},[s("span",[e._v(e._s(t.name))])]),e._v(" "),s("i",{staticClass:"deldata el-icon-delete",on:{click:function(t){return e.deldataone(0,a)}}})])}),e._v(" "),s("el-button",{attrs:{size:"mini"},on:{click:function(t){return e.modifyStuList(0)}}},[e._v("添加资料")])],2)]),e._v(" "),s("el-form-item",{attrs:{label:"参考答案："}},[s("div",{staticClass:"data-out"},[e._l(e.answerList,function(t,a){return s("p",{staticClass:"data-bg"},[s("a",{attrs:{target:"_blank",href:e.downurls+t.url}},[s("span",[e._v(e._s(t.name))])]),e._v(" "),s("i",{staticClass:"deldata el-icon-delete",on:{click:function(t){return e.deldataone(1,a)}}})])}),e._v(" "),s("el-button",{attrs:{size:"mini"},on:{click:function(t){return e.modifyStuList(1)}}},[e._v("添加资料")])],2)]),e._v(" "),s("el-form-item",[s("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.savedata}},[e._v("保 存")])],1)],1)],1)]),e._v(" "),s("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{title:"添加资料",visible:e.editVisible,width:"500px"},on:{"update:visible":function(t){e.editVisible=t}}},[s("div",{staticClass:"select-bg"},[s("span",[e._v("选择文件夹：")]),e._v(" "),s("el-select",{attrs:{size:"small",placeholder:"请选择"},on:{change:e.GetFileByFolderId},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}},e._l(e.options,function(e){return s("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}),1)],1),e._v(" "),s("el-table",{ref:"multipleTable",staticClass:"editlist",staticStyle:{width:"100%"},attrs:{size:"mini",data:e.tableData,"tooltip-effect":"dark",height:"300px"},on:{"selection-change":e.handleSelectionChange}},[s("el-table-column",{attrs:{type:"selection"}}),e._v(" "),s("el-table-column",{attrs:{prop:"name",label:"全选"}})],1),e._v(" "),s("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{attrs:{size:"small"},on:{click:function(t){e.editVisible=!1}}},[e._v("取 消")]),e._v(" "),s("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.savechoose}},[e._v("确 定")])],1)],1)],1)},staticRenderFns:[]};var d=s("VU/8")(c,u,!1,function(e){s("hKYV"),s("QYhb")},"data-v-6aef4788",null);t.default=d.exports},QYhb:function(e,t){},hKYV:function(e,t){}});
//# sourceMappingURL=8.5788126627d5bcadf208.js.map
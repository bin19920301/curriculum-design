webpackJsonp([11],{"8JP7":function(t,e){},AE5v:function(t,e){},JASZ:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=s("Xxa5"),i=s.n(a),r=s("exGp"),l=s.n(r),n=s("mrNh"),o=s("eOoE"),c={name:"course",components:{talkCmp:s("wNu5").a},data:function(){return{loading:!1,status:0,id:"",items:"",craftCardInfoDTOList:[],workMessageInfoDTOList:[],editVisible:!1,talktext:"",score:"",downurls:"",totalsi:0,startId:0,results:"",jichuanglist:[{id:1,name:"车床"},{id:2,name:"铣床"},{id:3,name:"刨床"},{id:4,name:"磨床"}],biaolist:""}},mounted:function(){this.downurls=o.a;var t=this.$route.params.id;this.id=t,this.Finishedsurface(),this.Getteachercardbyworkid(),this.Getworkinfobyid(),this.Teacherlistmessage(1)},methods:{closetrue:function(t){this.results.processList[t].close=!1},closefalse:function(t){this.results.processList[t].close=!0},Finishedsurface:function(){var t=this;return l()(i.a.mark(function e(){var s;return i.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,Object(n.F)(t.id);case 3:0==(s=e.sent).status.code?t.biaolist=s.result.list:t.$message.error(s.status.description),e.next=10;break;case 7:e.prev=7,e.t0=e.catch(0),console.log(e.t0);case 10:return e.prev=10,e.finish(10);case 12:case"end":return e.stop()}},e,t,[[0,7,10,12]])}))()},Getteachercardbyworkid:function(){var t=this;return l()(i.a.mark(function e(){var s,a;return i.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,Object(n.U)(t.id);case 3:0==(s=e.sent).status.code?((a=s.result).processList.forEach(function(t){t.close=!1}),console.log(a),t.results=a):t.$message.error(s.status.description),e.next=10;break;case 7:e.prev=7,e.t0=e.catch(0),console.log(e.t0);case 10:return e.prev=10,t.loading=!1,e.finish(10);case 13:case"end":return e.stop()}},e,t,[[0,7,10,13]])}))()},handleDelete:function(){var t=this;this.$confirm("确定要退回吗？","提示",{type:"warning"}).then(function(){t.Return()}).catch(function(){})},deletemessage:function(t){var e=this;this.$confirm("确定要删除吗？","提示",{type:"warning"}).then(function(){e.Deleteteahcermessage(t.id,t.index)}).catch(function(){})},Deleteteahcermessage:function(t,e){var s=this;return l()(i.a.mark(function a(){var r;return i.a.wrap(function(a){for(;;)switch(a.prev=a.next){case 0:return s.loading=!0,a.prev=1,a.next=4,Object(n.C)(t);case 4:0==(r=a.sent).status.code?(s.$message({showClose:!0,message:"删除成功",type:"success"}),s.workMessageInfoDTOList.splice(e,1)):s.$message.error(r.status.description),a.next=11;break;case 8:a.prev=8,a.t0=a.catch(1),console.log(a.t0);case 11:return a.prev=11,s.loading=!1,a.finish(11);case 14:case"end":return a.stop()}},a,s,[[1,8,11,14]])}))()},Score:function(){var t=this;return l()(i.a.mark(function e(){var s,a,r;return i.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:if(s=t.id,a=t.score){e.next=4;break}return t.$message({showClose:!0,message:"请输入评分",type:"warning"}),e.abrupt("return");case 4:return t.loading=!0,e.prev=6,e.next=9,Object(n._13)(s,a);case 9:0==(r=e.sent).status.code?(t.$message({showClose:!0,message:"评分成功",type:"success"}),t.editVisible=!1,t.Getworkinfobyid()):t.$message.error(r.status.description),e.next=16;break;case 13:e.prev=13,e.t0=e.catch(6),console.log(e.t0);case 16:return e.prev=16,t.loading=!1,e.finish(16);case 19:case"end":return e.stop()}},e,t,[[6,13,16,19]])}))()},Return:function(){var t=this;return l()(i.a.mark(function e(){var s,a;return i.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return t.loading=!0,s=t.id,e.prev=2,e.next=5,Object(n._12)(s);case 5:0==(a=e.sent).status.code?(t.$message({showClose:!0,message:"退回成功",type:"success"}),t.Getworkinfobyid()):t.$message.error(a.status.description),e.next=12;break;case 9:e.prev=9,e.t0=e.catch(2),console.log(e.t0);case 12:return e.prev=12,t.loading=!1,e.finish(12);case 15:case"end":return e.stop()}},e,t,[[2,9,12,15]])}))()},Addmessagebyteacher:function(t){var e=this;return l()(i.a.mark(function s(){var a,r;return i.a.wrap(function(s){for(;;)switch(s.prev=s.next){case 0:if(a=e.id,t){s.next=4;break}return e.$message({showClose:!0,message:"讨论内容不能为空",type:"warning"}),s.abrupt("return");case 4:return e.loading=!0,s.prev=6,s.next=9,Object(n.h)(a,t);case 9:0==(r=s.sent).status.code?(e.$message({showClose:!0,message:"发表成功",type:"success"}),e.talktext="",e.Teacherlistmessage(1)):e.$message.error(r.status.description),s.next=16;break;case 13:s.prev=13,s.t0=s.catch(6),console.log(s.t0);case 16:return s.prev=16,e.loading=!1,s.finish(16);case 19:case"end":return s.stop()}},s,e,[[6,13,16,19]])}))()},Getworkinfobyid:function(){var t=this;return l()(i.a.mark(function e(){var s,a;return i.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return t.loading=!0,s=t.id,e.prev=2,e.next=5,Object(n.Y)(s);case 5:0==(a=e.sent).status.code?(t.items=a.result,t.status=a.result.status):t.$message.error(a.status.description),e.next=12;break;case 9:e.prev=9,e.t0=e.catch(2),console.log(e.t0);case 12:return e.prev=12,t.loading=!1,e.finish(12);case 15:case"end":return e.stop()}},e,t,[[2,9,12,15]])}))()},getmore:function(t){this.Teacherlistmessage(t)},Teacherlistmessage:function(t){var e=this;return l()(i.a.mark(function s(){var a;return i.a.wrap(function(s){for(;;)switch(s.prev=s.next){case 0:return 10,1==t&&(e.workMessageInfoDTOList=[],e.startId=0,5),s.prev=3,s.next=6,Object(n._19)(e.id,t,5,e.startId);case 6:0==(a=s.sent).status.code?(1==t&&(e.startId=a.result.list[0].id),e.totalsi=a.result.total,e.workMessageInfoDTOList=a.result.list.reverse().concat(e.workMessageInfoDTOList)):e.$message.error(a.status.description),s.next=13;break;case 10:s.prev=10,s.t0=s.catch(3),console.log(s.t0);case 13:return s.prev=13,s.finish(13);case 15:case"end":return s.stop()}},s,e,[[3,10,13,15]])}))()}}},d={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"stuworkdetail"},[s("div",{staticClass:"crumbs"},[s("el-breadcrumb",{attrs:{separator:"/"}},[s("el-breadcrumb-item",[s("i",{staticClass:"el-icon-lx-calendar"}),t._v(" 课程设计\n            ")]),t._v(" "),t.items?s("el-breadcrumb-item",[t._v(t._s(t.items.teaching.name))]):t._e()],1)],1),t._v(" "),s("div",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticClass:"container"},[1==t.status?s("div",{staticClass:"modify-button"},[s("el-button",{attrs:{type:"danger",size:"small"},on:{click:t.handleDelete}},[t._v("退回")]),t._v(" "),s("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(e){t.editVisible=!0}}},[t._v("评分")])],1):t._e(),t._v(" "),3==t.status?s("div",{staticClass:"suc"},[s("el-alert",{attrs:{title:"作业已完成",closable:!1,effect:"dark",type:"success"}})],1):t._e(),t._v(" "),2==t.status?s("div",{staticClass:"suc"},[s("el-alert",{attrs:{title:"作业已退回",closable:!1,effect:"dark",type:"error"}})],1):t._e(),t._v(" "),t.items?s("div",{staticClass:"form"},[s("h3",[t._v(t._s(t.items.teaching.name))]),t._v(" "),s("el-form",{attrs:{"label-width":"90px"}},[s("el-form-item",{staticClass:"work-date",attrs:{size:"small",label:"指导老师："}},[t._v("\n                    "+t._s(t.items.teaching.teacherName)+"\n                ")]),t._v(" "),s("el-form-item",{staticClass:"work-date",attrs:{size:"small",label:"学生："}},[t._v("\n                    "+t._s(t.items.studentName)+"\n                ")]),t._v(" "),s("el-form-item",{staticClass:"work-date",attrs:{size:"small",label:"作业项目："}},[t._v("\n                    "+t._s(t.items.workProjectInfoDTO.name)+"\n                ")]),t._v(" "),s("el-form-item",{attrs:{label:"项目简介："}},[s("div",{staticClass:"teacherishi"},[t._v(t._s(t.items.workProjectInfoDTO.desc))])]),t._v(" "),s("el-form-item",{attrs:{label:"相关资料："}},[t._l(t.items.workProjectInfoDTO.filelist,function(e){return[s("a",{staticClass:"download-bg",attrs:{target:"_blank",href:t.downurls+e.url}},[s("el-button",{staticClass:"download",attrs:{type:"text"}},[t._v(t._s(e.name))]),t._v(" "),s("i",{staticClass:"el-icon-download"})],1),s("br")]})],2),t._v(" "),s("el-form-item",{attrs:{label:"参考答案："}},[t._l(t.items.workProjectInfoDTO.referenceSolutionList,function(e){return[s("a",{staticClass:"download-bg",attrs:{target:"_blank",href:t.downurls+e.url}},[s("el-button",{staticClass:"download",attrs:{type:"text"}},[t._v(t._s(e.name))]),t._v(" "),s("i",{staticClass:"el-icon-download"})],1),s("br")]})],2),t._v(" "),s("el-form-item",{attrs:{label:"工艺卡片："}},[s("div",{staticClass:"demo-input-size",staticStyle:{"margin-top":"10px",overflow:"hidden"}},[s("el-input",{staticClass:"fl",staticStyle:{width:"45%","margin-right":"9%"},attrs:{size:"small",placeholder:"请输入内容",disabled:""},model:{value:t.results.partNumber,callback:function(e){t.$set(t.results,"partNumber",e)},expression:"results.partNumber"}},[s("template",{slot:"prepend"},[t._v("零件号")])],2),t._v(" "),s("el-input",{staticClass:"fl",staticStyle:{width:"45%"},attrs:{size:"small",disabled:"",placeholder:"请输入内容"},model:{value:t.results.materials,callback:function(e){t.$set(t.results,"materials",e)},expression:"results.materials"}},[s("template",{slot:"prepend"},[t._v("材料")])],2)],1),t._v(" "),s("div",{staticClass:"demo-input-size",staticStyle:{"margin-top":"10px",overflow:"hidden"}},[s("el-input",{staticClass:"fl",staticStyle:{width:"45%","margin-right":"9%"},attrs:{size:"small",disabled:"",placeholder:"请输入内容"},model:{value:t.results.partName,callback:function(e){t.$set(t.results,"partName",e)},expression:"results.partName"}},[s("template",{slot:"prepend"},[t._v("零件名称")])],2),t._v(" "),s("el-input",{staticClass:"fl",staticStyle:{width:"45%"},attrs:{size:"small",disabled:"",placeholder:"请输入内容"},model:{value:t.results.workblankWeight,callback:function(e){t.$set(t.results,"workblankWeight",e)},expression:"results.workblankWeight"}},[s("template",{slot:"prepend"},[t._v("毛坯重量")])],2)],1),t._v(" "),s("div",{staticClass:"demo-input-size",staticStyle:{"margin-top":"10px",overflow:"hidden"}},[s("el-input",{staticClass:"fl",staticStyle:{width:"45%","margin-right":"9%"},attrs:{size:"small",placeholder:"请输入内容",disabled:""},model:{value:t.results.productType,callback:function(e){t.$set(t.results,"productType",e)},expression:"results.productType"}},[s("template",{slot:"prepend"},[t._v("生产类型")])],2),t._v(" "),s("el-input",{staticClass:"fl",staticStyle:{width:"45%"},attrs:{size:"small",disabled:"",placeholder:"请输入内容"},model:{value:t.results.workblankKind,callback:function(e){t.$set(t.results,"workblankKind",e)},expression:"results.workblankKind"}},[s("template",{slot:"prepend"},[t._v("毛坯种类")])],2)],1),t._v(" "),t._l(t.results.processList,function(e,a){return s("el-form",{key:a,ref:"form",refInFor:!0,class:{"form-in":!0,overflow:e.close},attrs:{"label-width":"85px"}},[s("h4",[e.close?s("i",{staticClass:"iconstyle el-icon-plus",on:{click:function(e){return t.closetrue(a)}}}):t._e(),e.close?t._e():s("i",{staticClass:"iconstyle el-icon-minus",on:{click:function(e){return t.closefalse(a)}}}),s("span",{staticStyle:{color:"#000","font-size":"16px"}},[t._v("工序 "+t._s(a+1)+" ")])]),t._v(" "),s("el-form-item",{staticClass:"work-date",attrs:{size:"small",label:"工序名称："}},[t._v("\n                        "+t._s(e.name)+"\n                      ")]),t._v(" "),s("el-form-item",{staticClass:"work-date",attrs:{size:"small",label:"加工表面："}},[s("el-select",{staticClass:"margin10",attrs:{disabled:"",size:"mini",placeholder:"请选择表面类型"},model:{value:e.surfaceId,callback:function(s){t.$set(e,"surfaceId",s)},expression:"item.surfaceId"}},t._l(t.biaolist,function(t){return s("el-option",{key:t.surfaceId,attrs:{label:t.name,value:t.surfaceId}})}),1)],1),t._v(" "),s("el-form-item",{staticClass:"work-date work-date-cont",attrs:{size:"small",label:"工序简图："}},[s("div",{staticClass:"picload-bg"},[s("a",{staticClass:"download-bg",attrs:{target:"_blank",href:t.downurls+e.processFile.path}},[s("img",{staticClass:"fl imgshow",attrs:{src:t.downurls+e.processFile.path,alt:""}})])])]),t._v(" "),t._l(e.workingPositionList,function(e,a){return s("el-form",{key:a,staticClass:"form-in",staticStyle:{"margin-bottom":"10px",background:"#fff"},attrs:{"label-width":"85px"}},[s("h4",[s("span",{staticStyle:{color:"#333","font-size":"15px"}},[t._v("工位 "+t._s(a+1)+" ")])]),t._v(" "),t._l(e.workingStepList,function(e,a){return s("el-form",{key:a,staticClass:"form-in",staticStyle:{background:"#fcfcfc","margin-bottom":"10px",border:"1px dashed #ccc"},attrs:{"label-width":"85px"}},[s("h4",{staticStyle:{"border-bottom":"1px dashed #ccc"}},[s("span",{staticStyle:{color:"#666","font-size":"14px"}},[t._v("工步 "+t._s(a+1))])]),t._v(" "),s("div",{staticClass:"demo-input-size",staticStyle:{"margin-top":"10px",overflow:"hidden"}},[s("div",{staticClass:"inp-bg",staticStyle:{"margin-right":"4%"}},[s("span",{staticClass:"span"},[t._v("机床：")]),t._v(" "),s("el-select",{staticClass:"margin10",attrs:{disabled:"",size:"mini",placeholder:"请选择机床"},model:{value:e.tool,callback:function(s){t.$set(e,"tool",s)},expression:"item2.tool"}},t._l(t.jichuanglist,function(t){return s("el-option",{key:t.id,attrs:{label:t.name,value:t.id}})}),1)],1),t._v(" "),s("div",{staticClass:"inp-bg"},[s("span",{staticClass:"span"},[t._v("夹具或辅助工具：")]),t._v(" "),s("el-input",{staticClass:"inp-cont",attrs:{size:"mini",disabled:"",placeholder:"请输入内容"},model:{value:e.fixture,callback:function(s){t.$set(e,"fixture",s)},expression:"item2.fixture"}})],1)]),t._v(" "),s("div",{staticClass:"demo-input-size",staticStyle:{"margin-top":"10px",overflow:"hidden"}},[s("div",{staticClass:"inp-bg",staticStyle:{"margin-right":"4%"}},[s("span",{staticClass:"span"},[t._v("刀具：")]),t._v(" "),s("el-input",{staticClass:"inp-cont",attrs:{size:"mini",disabled:"",placeholder:"请输入内容"},model:{value:e.cutter,callback:function(s){t.$set(e,"cutter",s)},expression:"item2.cutter"}})],1),t._v(" "),s("div",{staticClass:"inp-bg"},[s("span",{staticClass:"span"},[t._v("走刀深度（mm）：")]),t._v(" "),s("el-input",{staticClass:"inp-cont",attrs:{size:"mini",disabled:"",placeholder:"请输入内容"},model:{value:e.feedingDepth,callback:function(s){t.$set(e,"feedingDepth",s)},expression:"item2.feedingDepth"}})],1)]),t._v(" "),s("div",{staticClass:"demo-input-size",staticStyle:{"margin-top":"10px",overflow:"hidden"}},[s("div",{staticClass:"inp-bg",staticStyle:{"margin-right":"4%"}},[s("span",{staticClass:"span"},[t._v("切削深度（mm）：")]),t._v(" "),s("el-input",{staticClass:"inp-cont",attrs:{size:"mini",disabled:"",placeholder:"请输入内容"},model:{value:e.cutDepth,callback:function(s){t.$set(e,"cutDepth",s)},expression:"item2.cutDepth"}})],1),t._v(" "),s("div",{staticClass:"inp-bg"},[s("span",{staticClass:"span"},[t._v("进给量（mm/r)：")]),t._v(" "),s("el-input",{staticClass:"inp-cont",attrs:{size:"mini",disabled:"",placeholder:"请输入内容"},model:{value:e.load,callback:function(s){t.$set(e,"load",s)},expression:"item2.load"}})],1)]),t._v(" "),s("div",{staticClass:"demo-input-size",staticStyle:{"margin-top":"10px",overflow:"hidden"}},[s("div",{staticClass:"inp-bg",staticStyle:{"margin-right":"4%"}},[s("span",{staticClass:"span"},[t._v("主轴转速（r/min)：")]),t._v(" "),s("el-input",{staticClass:"inp-cont",attrs:{size:"mini",disabled:"",placeholder:"请输入内容"},model:{value:e.mainshaftSpeed,callback:function(s){t.$set(e,"mainshaftSpeed",s)},expression:"item2.mainshaftSpeed"}})],1),t._v(" "),s("div",{staticClass:"inp-bg"},[s("span",{staticClass:"span"},[t._v("切削速度（m/min)：")]),t._v(" "),s("el-input",{staticClass:"inp-cont",attrs:{size:"mini",disabled:"",placeholder:"请输入内容"},model:{value:e.cutSpeed,callback:function(s){t.$set(e,"cutSpeed",s)},expression:"item2.cutSpeed"}})],1)]),t._v(" "),s("div",{staticClass:"demo-input-size",staticStyle:{"margin-top":"10px",overflow:"hidden",position:"relative","padding-left":"120px","box-sizing":"border-box"}},[s("span",{staticStyle:{position:"absolute",top:"0",left:"0"}},[t._v("工时定额（min）：")]),t._v(" "),s("div",{staticClass:"inp-bg",staticStyle:{width:"33%","margin-right":"2%","padding-left":"80px"}},[s("span",{staticClass:"span"},[t._v("基本时间：")]),t._v(" "),s("el-input",{staticClass:"inp-cont",attrs:{size:"mini",disabled:"",placeholder:"请输入内容"},model:{value:e.basicTime,callback:function(s){t.$set(e,"basicTime",s)},expression:"item2.basicTime"}})],1),t._v(" "),s("div",{staticClass:"inp-bg",staticStyle:{width:"33%","margin-right":"2%","padding-left":"80px"}},[s("span",{staticClass:"span"},[t._v("辅助时间：")]),t._v(" "),s("el-input",{staticClass:"inp-cont",attrs:{size:"mini",disabled:"",placeholder:"请输入内容"},model:{value:e.assistTime,callback:function(s){t.$set(e,"assistTime",s)},expression:"item2.assistTime"}})],1),t._v(" "),s("div",{staticClass:"inp-bg",staticStyle:{width:"30%","padding-left":"120px"}},[s("span",{staticClass:"span"},[t._v("工作地服务时间：")]),t._v(" "),s("el-input",{staticClass:"inp-cont",attrs:{size:"mini",disabled:"",placeholder:"请输入内容"},model:{value:e.workspaceServiceTime,callback:function(s){t.$set(e,"workspaceServiceTime",s)},expression:"item2.workspaceServiceTime"}})],1)])])})],2)})],2)})],2),t._v(" "),s("el-form-item",{attrs:{label:"作业附件："}},[t._l(t.items.workFileDTOList,function(e){return[s("a",{staticClass:"download-bg",attrs:{target:"_blank",href:t.downurls+e.url}},[s("el-button",{staticClass:"download",attrs:{type:"text"}},[t._v(t._s(e.name))]),t._v(" "),s("i",{staticClass:"el-icon-download"})],1),s("br")]})],2),t._v(" "),s("el-form-item",{attrs:{label:"作业讨论："}},[s("el-tabs",{attrs:{type:"border-card"}},[s("el-tab-pane",{attrs:{label:"私信老师"}},[s("talkCmp",{attrs:{workMessageInfoDTOList:t.workMessageInfoDTOList,total:t.totalsi},on:{getmore:t.getmore,pus:t.Addmessagebyteacher,dele:t.deletemessage}})],1)],1)],1)],1)],1):t._e()]),t._v(" "),s("el-dialog",{attrs:{title:"评分",visible:t.editVisible,width:"30%"},on:{"update:visible":function(e){t.editVisible=e}}},[s("el-form",{ref:"form",attrs:{"label-width":"70px"}},[s("el-form-item",{attrs:{label:"评分："}},[s("el-input",{attrs:{size:"small",onkeyup:"this.value=this.value.replace(/[^\\d.]/g,'');",maxlength:"3"},model:{value:t.score,callback:function(e){t.score=e},expression:"score"}})],1)],1),t._v(" "),s("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{attrs:{size:"small"},on:{click:function(e){t.editVisible=!1}}},[t._v("取 消")]),t._v(" "),s("el-button",{attrs:{type:"primary",size:"small"},on:{click:t.Score}},[t._v("确 定")])],1)],1)],1)},staticRenderFns:[]};var u=s("VU/8")(c,d,!1,function(t){s("AE5v"),s("8JP7")},"data-v-64d5fa47",null);e.default=u.exports}});
//# sourceMappingURL=11.0dea8c2b33c0e5ce4933.js.map
var collect=function(t){function r(e){if(n[e])return n[e].exports;var i=n[e]={i:e,l:!1,exports:{}};return t[e].call(i.exports,i,i.exports,r),i.l=!0,i.exports}var n={};return r.m=t,r.c=n,r.d=function(t,n,e){r.o(t,n)||Object.defineProperty(t,n,{configurable:!1,enumerable:!0,get:e})},r.n=function(t){var n=t&&t.__esModule?function(){return t.default}:function(){return t};return r.d(n,"a",n),n},r.o=function(t,r){return Object.prototype.hasOwnProperty.call(t,r)},r.p="",r(r.s=3)}([function(t,r,n){"use strict";function e(t){if(Array.isArray(t)){for(var r=0,n=Array(t.length);r<t.length;r++)n[r]=t[r];return n}return Array.from(t)}t.exports=function(t){var r=[];return Array.isArray(t)?r.push.apply(r,e(t)):"Collection"===t.constructor.name?r.push.apply(r,e(t.all())):Object.keys(t).forEach(function(n){return r.push(t[n])}),r}},function(t,r,n){"use strict";t.exports=function(t){return Array.isArray(t[0])?t[0]:t}},function(t,r,n){"use strict";t.exports=function(t){return void 0===t?this.sum()/this.items.length:new this.constructor(this.items).pluck(t).sum()/this.items.length}},function(t,r,n){"use strict";function e(t){this.items=t||[]}var i=n(4);"undefined"!=typeof Symbol&&(e.prototype[Symbol.iterator]=i),e.prototype.all=n(5),e.prototype.average=n(2),e.prototype.avg=n(2),e.prototype.chunk=n(6),e.prototype.collapse=n(7),e.prototype.combine=n(8),e.prototype.concat=n(9),e.prototype.contains=n(10),e.prototype.count=n(11),e.prototype.crossJoin=n(12),e.prototype.dd=n(13),e.prototype.diff=n(15),e.prototype.diffAssoc=n(16),e.prototype.diffKeys=n(17),e.prototype.dump=n(18),e.prototype.each=n(19),e.prototype.eachSpread=n(20),e.prototype.every=n(21),e.prototype.except=n(22),e.prototype.filter=n(23),e.prototype.first=n(24),e.prototype.firstWhere=n(25),e.prototype.flatMap=n(26),e.prototype.flatten=n(27),e.prototype.flip=n(28),e.prototype.forPage=n(29),e.prototype.forget=n(30),e.prototype.get=n(31),e.prototype.groupBy=n(32),e.prototype.has=n(33),e.prototype.implode=n(34),e.prototype.intersect=n(35),e.prototype.intersectByKeys=n(36),e.prototype.isEmpty=n(37),e.prototype.isNotEmpty=n(38),e.prototype.keyBy=n(39),e.prototype.keys=n(40),e.prototype.last=n(41),e.prototype.macro=n(42),e.prototype.map=n(43),e.prototype.mapSpread=n(44),e.prototype.mapToDictionary=n(45),e.prototype.mapInto=n(46),e.prototype.mapToGroups=n(47),e.prototype.mapWithKeys=n(48),e.prototype.max=n(49),e.prototype.median=n(50),e.prototype.merge=n(51),e.prototype.min=n(52),e.prototype.mode=n(53),e.prototype.nth=n(54),e.prototype.only=n(55),e.prototype.pad=n(56),e.prototype.partition=n(58),e.prototype.pipe=n(59),e.prototype.pluck=n(60),e.prototype.pop=n(61),e.prototype.prepend=n(62),e.prototype.pull=n(63),e.prototype.push=n(64),e.prototype.put=n(65),e.prototype.random=n(66),e.prototype.reduce=n(67),e.prototype.reject=n(68),e.prototype.reverse=n(69),e.prototype.search=n(70),e.prototype.shift=n(71),e.prototype.shuffle=n(72),e.prototype.slice=n(73),e.prototype.sort=n(74),e.prototype.sortBy=n(75),e.prototype.sortByDesc=n(76),e.prototype.splice=n(77),e.prototype.split=n(78),e.prototype.sum=n(79),e.prototype.take=n(80),e.prototype.tap=n(81),e.prototype.times=n(82),e.prototype.toArray=n(83),e.prototype.toJson=n(84),e.prototype.transform=n(85),e.prototype.unless=n(86),e.prototype.union=n(87),e.prototype.unique=n(88),e.prototype.unwrap=n(89),e.prototype.values=n(90),e.prototype.when=n(91),e.prototype.where=n(92),e.prototype.whereIn=n(93),e.prototype.whereNotIn=n(94),e.prototype.wrap=n(95),e.prototype.zip=n(96);var o=function(t){return new e(t)};t.exports=o,t.exports.default=o},function(t,r,n){"use strict";t.exports=function(){var t=this,r=-1;return{next:function(){return r+=1,{value:t.items[r],done:r>=t.items.length}}}}},function(t,r,n){"use strict";t.exports=function(){return this.items}},function(t,r,n){"use strict";var e="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t};t.exports=function(t){var r=this,n=[],i=0;if(Array.isArray(this.items))do{var o=this.items.slice(i,i+t),s=new this.constructor(o);n.push(s),i+=t}while(i<this.items.length);else if("object"===e(this.items)){var u=Object.keys(this.items),c=function(){var e=u.slice(i,i+t),o=new r.constructor({});e.forEach(function(t){return o.put(t,r.items[t])}),n.push(o),i+=t};do{c()}while(i<u.length)}else n.push(new this.constructor([this.items]));return new this.constructor(n)}},function(t,r,n){"use strict";t.exports=function(){var t;return new this.constructor((t=[]).concat.apply(t,function(t){if(Array.isArray(t)){for(var r=0,n=Array(t.length);r<t.length;r++)n[r]=t[r];return n}return Array.from(t)}(this.items)))}},function(t,r,n){"use strict";var e="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t};t.exports=function(t){var r=this,n=t;n instanceof this.constructor&&(n=t.all());var i={};return Array.isArray(this.items)&&Array.isArray(n)?this.items.forEach(function(t,r){i[t]=n[r]}):"object"===e(this.items)&&"object"===(void 0===n?"undefined":e(n))?Object.keys(this.items).forEach(function(t,e){i[r.items[t]]=n[Object.keys(n)[e]]}):Array.isArray(this.items)?i[this.items[0]]=n:"string"==typeof this.items&&Array.isArray(n)?i[this.items]=n[0]:"string"==typeof this.items&&(i[this.items]=n),new this.constructor(i)}},function(t,r,n){"use strict";var e="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t};t.exports=function(t){var r=this,n=t;return t instanceof this.constructor?n=t.all():"object"===(void 0===t?"undefined":e(t))&&(n=[],Object.keys(t).forEach(function(r){n.push(t[r])})),n.forEach(function(t){"object"===(void 0===t?"undefined":e(t))?Object.keys(t).forEach(function(n){return r.items.push(t[n])}):r.items.push(t)}),this}},function(t,r,n){"use strict";t.exports=function(t,r){return void 0!==r?Array.isArray(this.items)?this.items.filter(function(n){return void 0!==n[t]&&n[t]===r}).length>0:void 0!==this.items[t]&&this.items[t]===r:"function"==typeof t?this.items.filter(function(r,n){return t(r,n)}).length>0:Array.isArray(this.items)?-1!==this.items.indexOf(t):void 0!==this.items[t]}},function(t,r,n){"use strict";t.exports=function(){return Array.isArray(this.items)?this.items.length:Object.keys(this.items).length}},function(t,r,n){"use strict";t.exports=function(){function t(r,n,e){var i=e[0];i instanceof n&&(i=i.all());for(var o=e.slice(1),s=!o.length,u=[],c=0;c<i.length;c+=1){var f=r.slice();f.push(i[c]),s?u.push(f):u=u.concat(t(f,n,o))}return u}for(var r=arguments.length,n=Array(r),e=0;e<r;e++)n[e]=arguments[e];return new this.constructor(t([],this.constructor,[].concat([this.items],n)))}},function(t,r,n){"use strict";(function(r){t.exports=function(){console.log(this.all()),void 0!==r&&r.exit(1)}}).call(r,n(14))},function(t,r){function n(){throw new Error("setTimeout has not been defined")}function e(){throw new Error("clearTimeout has not been defined")}function i(t){if(f===setTimeout)return setTimeout(t,0);if((f===n||!f)&&setTimeout)return f=setTimeout,setTimeout(t,0);try{return f(t,0)}catch(r){try{return f.call(null,t,0)}catch(r){return f.call(this,t,0)}}}function o(){l&&p&&(l=!1,p.length?y=p.concat(y):m=-1,y.length&&s())}function s(){if(!l){var t=i(o);l=!0;for(var r=y.length;r;){for(p=y,y=[];++m<r;)p&&p[m].run();m=-1,r=y.length}p=null,l=!1,function(t){if(a===clearTimeout)return clearTimeout(t);if((a===e||!a)&&clearTimeout)return a=clearTimeout,clearTimeout(t);try{a(t)}catch(r){try{return a.call(null,t)}catch(r){return a.call(this,t)}}}(t)}}function u(t,r){this.fun=t,this.array=r}function c(){}var f,a,h=t.exports={};!function(){try{f="function"==typeof setTimeout?setTimeout:n}catch(t){f=n}try{a="function"==typeof clearTimeout?clearTimeout:e}catch(t){a=e}}();var p,y=[],l=!1,m=-1;h.nextTick=function(t){var r=new Array(arguments.length-1);if(arguments.length>1)for(var n=1;n<arguments.length;n++)r[n-1]=arguments[n];y.push(new u(t,r)),1!==y.length||l||i(s)},u.prototype.run=function(){this.fun.apply(null,this.array)},h.title="browser",h.browser=!0,h.env={},h.argv=[],h.version="",h.versions={},h.on=c,h.addListener=c,h.once=c,h.off=c,h.removeListener=c,h.removeAllListeners=c,h.emit=c,h.prependListener=c,h.prependOnceListener=c,h.listeners=function(t){return[]},h.binding=function(t){throw new Error("process.binding is not supported")},h.cwd=function(){return"/"},h.chdir=function(t){throw new Error("process.chdir is not supported")},h.umask=function(){return 0}},function(t,r,n){"use strict";t.exports=function(t){var r=void 0;r=t instanceof this.constructor?t.all():t;var n=this.items.filter(function(t){return-1===r.indexOf(t)});return new this.constructor(n)}},function(t,r,n){"use strict";t.exports=function(t){var r=this,n=t;t instanceof this.constructor&&(n=t.all());var e={};return Object.keys(this.items).forEach(function(t){void 0!==n[t]&&n[t]===r.items[t]||(e[t]=r.items[t])}),new this.constructor(e)}},function(t,r,n){"use strict";t.exports=function(t){var r=void 0;r=t instanceof this.constructor?t.all():t;var n=Object.keys(r),e=Object.keys(this.items).filter(function(t){return-1===n.indexOf(t)});return new this.constructor(this.items).only(e)}},function(t,r,n){"use strict";t.exports=function(){return console.log(this),this}},function(t,r,n){"use strict";t.exports=function(t){var r=this;return Array.isArray(this.items)?this.items.forEach(t):Object.keys(this.items).forEach(function(n){t(r.items[n],n,r.items)}),this}},function(t,r,n){"use strict";t.exports=function(t){return this.each(function(r,n){t.apply(void 0,function(t){if(Array.isArray(t)){for(var r=0,n=Array(t.length);r<t.length;r++)n[r]=t[r];return n}return Array.from(t)}(r).concat([n]))}),this}},function(t,r,n){"use strict";var e=n(0);t.exports=function(t){return-1===e(this.items).map(function(r,n){return t(r,n)}).indexOf(!1)}},function(t,r,n){"use strict";var e=n(1);t.exports=function(){for(var t=this,r=arguments.length,n=Array(r),i=0;i<r;i++)n[i]=arguments[i];var o=e(n);if(Array.isArray(this.items)){var s=this.items.filter(function(t){return-1===o.indexOf(t)});return new this.constructor(s)}var u={};return Object.keys(this.items).forEach(function(r){-1===o.indexOf(r)&&(u[r]=t.items[r])}),new this.constructor(u)}},function(t,r,n){"use strict";function e(t){if(Array.isArray(t)){if(t.length)return!1}else if(void 0!==t&&null!==t&&"object"===(void 0===t?"undefined":i(t))){if(Object.keys(t).length)return!1}else if(t)return!1;return!0}var i="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t};t.exports=function(t){var r=t||!1,n=null;return n=Array.isArray(this.items)?function(t,r){if(t)return r.filter(t);for(var n=[],i=0;i<r.length;i+=1){var o=r[i];e(o)||n.push(o)}return n}(r,this.items):function(t,r){var n={};return Object.keys(r).forEach(function(i){t?t(r[i],i)&&(n[i]=r[i]):e(r[i])||(n[i]=r[i])}),n}(r,this.items),new this.constructor(n)}},function(t,r,n){"use strict";t.exports=function(t,r){if("function"==typeof t){for(var n=0,e=this.items.length;n<e;n+=1){var i=this.items[n];if(t(i))return i}return"function"==typeof r?r():r}if(Array.isArray(this.items)&&this.items.length||Object.keys(this.items).length){if(Array.isArray(this.items))return this.items[0];var o=Object.keys(this.items)[0];return this.items[o]}return"function"==typeof r?r():r}},function(t,r,n){"use strict";t.exports=function(t,r){return this.where(t,r).first()||null}},function(t,r,n){"use strict";t.exports=function(t){var r=[];return this.items.forEach(function(n,e){var i=Object.keys(n),o=[];i.forEach(function(t){o.push(n[t])});var s=t(o,e),u={};i.forEach(function(t,r){u[t]=s[r]}),r.push(u)}),new this.constructor(Object.assign.apply(Object,r))}},function(t,r,n){"use strict";var e="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t};t.exports=function(t){var r=t||1/0,n=!1,i=[],o=function(t){i=[],Array.isArray(t)?t.forEach(function(t){"string"==typeof t?i.push(t):Array.isArray(t)?i=i.concat(t):Object.keys(t).forEach(function(r){i=i.concat(t[r])})}):Object.keys(t).forEach(function(r){"string"==typeof t[r]?i.push(t[r]):Array.isArray(t[r])?i=i.concat(t[r]):Object.keys(t).forEach(function(r){i=i.concat(t[r])})}),n=0===(n=i.filter(function(t){return"object"===(void 0===t?"undefined":e(t))})).length,r-=1};for(o(this.items);!n&&r>0;)o(i);return new this.constructor(i)}},function(t,r,n){"use strict";t.exports=function(){var t=this,r={};return Array.isArray(this.items)?Object.keys(this.items).forEach(function(n){r[t.items[n]]=Number(n)}):Object.keys(this.items).forEach(function(n){r[t.items[n]]=n}),new this.constructor(r)}},function(t,r,n){"use strict";t.exports=function(t,r){var n=this,e={};return Array.isArray(this.items)?e=this.items.slice(t*r-r,t*r):Object.keys(this.items).slice(t*r-r,t*r).forEach(function(t){e[t]=n.items[t]}),new this.constructor(e)}},function(t,r,n){"use strict";t.exports=function(t){return Array.isArray(this.items)?this.items.splice(t,1):delete this.items[t],this}},function(t,r,n){"use strict";t.exports=function(t){var r=arguments.length>1&&void 0!==arguments[1]?arguments[1]:null;return void 0!==this.items[t]?this.items[t]:"function"==typeof r?r():null!==r?r:null}},function(t,r,n){"use strict";t.exports=function(t){var r=this,n={};return this.items.forEach(function(e,i){var o=void 0;o="function"==typeof t?t(e,i):e[t]||"",void 0===n[o]&&(n[o]=new r.constructor([])),n[o].push(e)}),new this.constructor(n)}},function(t,r,n){"use strict";var e=n(1);t.exports=function(){for(var t=this,r=arguments.length,n=Array(r),i=0;i<r;i++)n[i]=arguments[i];var o=e(n);return o.filter(function(r){return t.items[r]}).length===o.length}},function(t,r,n){"use strict";t.exports=function(t,r){return void 0===r?this.items.join(t):new this.constructor(this.items).pluck(t).all().join(r)}},function(t,r,n){"use strict";t.exports=function(t){var r=t;t instanceof this.constructor&&(r=t.all());var n=this.items.filter(function(t){return-1!==r.indexOf(t)});return new this.constructor(n)}},function(t,r,n){"use strict";t.exports=function(t){var r=this,n=Object.keys(t);t instanceof this.constructor&&(n=Object.keys(t.all()));var e={};return Object.keys(this.items).forEach(function(t){-1!==n.indexOf(t)&&(e[t]=r.items[t])}),new this.constructor(e)}},function(t,r,n){"use strict";t.exports=function(){return!this.items.length}},function(t,r,n){"use strict";t.exports=function(){return!!this.items.length}},function(t,r,n){"use strict";t.exports=function(t){var r={};return"function"==typeof t?this.items.forEach(function(n){r[t(n)]=n}):this.items.forEach(function(n){r[n[t]||""]=n}),new this.constructor(r)}},function(t,r,n){"use strict";t.exports=function(){var t=Object.keys(this.items);return Array.isArray(this.items)&&(t=t.map(Number)),new this.constructor(t)}},function(t,r,n){"use strict";t.exports=function(t,r){var n=this.items;if("function"==typeof t&&(n=this.filter(t).all()),Array.isArray(n)&&!n.length||!Object.keys(n).length)return"function"==typeof r?r():r;if(Array.isArray(n))return n[n.length-1];var e=Object.keys(n);return n[e[e.length-1]]}},function(t,r,n){"use strict";t.exports=function(t,r){this.constructor.prototype[t]=r}},function(t,r,n){"use strict";t.exports=function(t){var r=this;if(Array.isArray(this.items))return new this.constructor(this.items.map(t));var n={};return Object.keys(this.items).forEach(function(e){n[e]=t(r.items[e],e)}),new this.constructor(n)}},function(t,r,n){"use strict";t.exports=function(t){return this.map(function(r,n){return t.apply(void 0,function(t){if(Array.isArray(t)){for(var r=0,n=Array(t.length);r<t.length;r++)n[r]=t[r];return n}return Array.from(t)}(r).concat([n]))})}},function(t,r,n){"use strict";var e=function(){return function(t,r){if(Array.isArray(t))return t;if(Symbol.iterator in Object(t))return function(t,r){var n=[],e=!0,i=!1,o=void 0;try{for(var s,u=t[Symbol.iterator]();!(e=(s=u.next()).done)&&(n.push(s.value),!r||n.length!==r);e=!0);}catch(t){i=!0,o=t}finally{try{!e&&u.return&&u.return()}finally{if(i)throw o}}return n}(t,r);throw new TypeError("Invalid attempt to destructure non-iterable instance")}}();t.exports=function(t){var r={};return this.items.forEach(function(n,i){var o=t(n,i),s=e(o,2),u=s[0],c=s[1];void 0===r[u]?r[u]=[c]:r[u].push(c)}),new this.constructor(r)}},function(t,r,n){"use strict";t.exports=function(t){return this.map(function(r,n){return new t(r,n)})}},function(t,r,n){"use strict";var e=function(){return function(t,r){if(Array.isArray(t))return t;if(Symbol.iterator in Object(t))return function(t,r){var n=[],e=!0,i=!1,o=void 0;try{for(var s,u=t[Symbol.iterator]();!(e=(s=u.next()).done)&&(n.push(s.value),!r||n.length!==r);e=!0);}catch(t){i=!0,o=t}finally{try{!e&&u.return&&u.return()}finally{if(i)throw o}}return n}(t,r);throw new TypeError("Invalid attempt to destructure non-iterable instance")}}();t.exports=function(t){var r={};return this.items.forEach(function(n,i){var o=t(n,i),s=e(o,2),u=s[0],c=s[1];void 0===r[u]?r[u]=[c]:r[u].push(c)}),new this.constructor(r)}},function(t,r,n){"use strict";var e=function(){return function(t,r){if(Array.isArray(t))return t;if(Symbol.iterator in Object(t))return function(t,r){var n=[],e=!0,i=!1,o=void 0;try{for(var s,u=t[Symbol.iterator]();!(e=(s=u.next()).done)&&(n.push(s.value),!r||n.length!==r);e=!0);}catch(t){i=!0,o=t}finally{try{!e&&u.return&&u.return()}finally{if(i)throw o}}return n}(t,r);throw new TypeError("Invalid attempt to destructure non-iterable instance")}}();t.exports=function(t){var r=this,n={};return Array.isArray(this.items)?this.items.forEach(function(r){var i=t(r),o=e(i,2),s=o[0],u=o[1];n[s]=u}):Object.keys(this.items).forEach(function(i){var o=t(r.items[i]),s=e(o,2),u=s[0],c=s[1];n[u]=c}),new this.constructor(n)}},function(t,r,n){"use strict";function e(t){if(Array.isArray(t)){for(var r=0,n=Array(t.length);r<t.length;r++)n[r]=t[r];return n}return Array.from(t)}t.exports=function(t){return"string"==typeof t?Math.max.apply(Math,e(this.pluck(t).all())):Math.max.apply(Math,e(this.items))}},function(t,r,n){"use strict";t.exports=function(t){var r=this.items.length;return void 0===t?r%2==0?(this.items[r/2-1]+this.items[r/2])/2:this.items[Math.floor(r/2)]:r%2==0?(this.items[r/2-1][t]+this.items[r/2][t])/2:this.items[Math.floor(r/2)][t]}},function(t,r,n){"use strict";t.exports=function(t){var r=t;if("string"==typeof r&&(r=[r]),Array.isArray(this.items)&&Array.isArray(r))return new this.constructor(this.items.concat(r));var n=JSON.parse(JSON.stringify(this.items));return Object.keys(r).forEach(function(t){n[t]=r[t]}),new this.constructor(n)}},function(t,r,n){"use strict";function e(t){if(Array.isArray(t)){for(var r=0,n=Array(t.length);r<t.length;r++)n[r]=t[r];return n}return Array.from(t)}t.exports=function(t){return void 0!==t?Math.min.apply(Math,e(this.pluck(t).all())):Math.min.apply(Math,e(this.items))}},function(t,r,n){"use strict";t.exports=function(t){var r=[],n=1;return this.items.length?(this.items.forEach(function(e){var i=r.filter(function(r){return void 0!==t?r.key===e[t]:r.key===e});if(i.length){i[0].count+=1;var o=i[0].count;o>n&&(n=o)}else void 0!==t?r.push({key:e[t],count:1}):r.push({key:e,count:1})}),r.filter(function(t){return t.count===n}).map(function(t){return t.key})):null}},function(t,r,n){"use strict";var e=n(0);t.exports=function(t){var r=arguments.length>1&&void 0!==arguments[1]?arguments[1]:0,n=e(this.items).slice(r).filter(function(r,n){return n%t==0});return new this.constructor(n)}},function(t,r,n){"use strict";var e=n(1);t.exports=function(){for(var t=this,r=arguments.length,n=Array(r),i=0;i<r;i++)n[i]=arguments[i];var o=e(n);if(Array.isArray(this.items)){var s=this.items.filter(function(t){return-1!==o.indexOf(t)});return new this.constructor(s)}var u={};return Object.keys(this.items).forEach(function(r){-1!==o.indexOf(r)&&(u[r]=t.items[r])}),new this.constructor(u)}},function(t,r,n){"use strict";var e=n(57);t.exports=function(t,r){var n=Math.abs(t),i=this.count();if(n<=i)return this;for(var o=n-i,s=e(this.items),u=Array.isArray(this.items),c=t<0,f=0;f<o;)u?c?s.unshift(r):s.push(r):void 0!==s[f]?o+=1:s[f]=r,f+=1;return new this.constructor(s)}},function(t,r,n){"use strict";t.exports=function(t){var r=void 0;if(Array.isArray(t)){var n;(n=r=[]).push.apply(n,function(t){if(Array.isArray(t)){for(var r=0,n=Array(t.length);r<t.length;r++)n[r]=t[r];return n}return Array.from(t)}(t))}else r={},Object.keys(t).forEach(function(n){r[n]=t[n]});return r}},function(t,r,n){"use strict";t.exports=function(t){var r=this,n=void 0;return Array.isArray(this.items)?(n=[new this.constructor([]),new this.constructor([])],this.items.forEach(function(r){!0===t(r)?n[0].push(r):n[1].push(r)})):(n=[new this.constructor({}),new this.constructor({})],Object.keys(this.items).forEach(function(e){var i=r.items[e];!0===t(i)?n[0].put(e,i):n[1].put(e,i)})),new this.constructor(n)}},function(t,r,n){"use strict";t.exports=function(t){return t(this)}},function(t,r,n){"use strict";t.exports=function(t,r){if(void 0!==r){var n={};return this.items.forEach(function(e){n[e[r]||""]=e[t]||null}),new this.constructor(n)}return this.map(function(r){return r[t]||null})}},function(t,r,n){"use strict";t.exports=function(){if(Array.isArray(this.items))return this.items.pop();var t=Object.keys(this.items),r=t[t.length-1],n=this.items[r];return delete this.items[r],n}},function(t,r,n){"use strict";t.exports=function(t,r){return void 0!==r?this.put(r,t):(this.items.unshift(t),this)}},function(t,r,n){"use strict";t.exports=function(t,r){var n=this.items[t]||null;return n||void 0===r||(n="function"==typeof r?r():r),delete this.items[t],n}},function(t,r,n){"use strict";t.exports=function(){var t;return(t=this.items).push.apply(t,arguments),this}},function(t,r,n){"use strict";t.exports=function(t,r){return this.items[t]=r,this}},function(t,r,n){"use strict";var e=n(0);t.exports=function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:1,r=e(this.items),n=new this.constructor(r).shuffle();return 1===t?n.first():n.take(t)}},function(t,r,n){"use strict";t.exports=function(t,r){var n=this,e=null,i=null;return void 0!==r&&(i=r),Array.isArray(this.items)?this.items.forEach(function(r){e=t(i,r),i=e}):Object.keys(this.items).forEach(function(r){e=t(i,n.items[r],r),i=e}),e}},function(t,r,n){"use strict";t.exports=function(t){return new this.constructor(this.items.filter(function(r){return!t(r)}))}},function(t,r,n){"use strict";t.exports=function(){var t=[].concat(this.items).reverse();return new this.constructor(t)}},function(t,r,n){"use strict";t.exports=function(t,r){var n=this,e=t;"function"==typeof t&&(e=this.items.filter(function(r,n){return t(r,n)})[0]);var i=!1;if(!Array.isArray(this.items))return Object.keys(this.items).filter(function(t){return!0===r?n.items[t]===e:n.items[t]===Number(e)||n.items[t]===e.toString()})[0]||!1;var o=this.items.filter(function(t){return!0===r?t===e:t===Number(e)||t===e.toString()})[0];return-1!==(i=this.items.indexOf(o))&&i}},function(t,r,n){"use strict";t.exports=function(){if(Array.isArray(this.items))return this.items.shift();var t=Object.keys(this.items)[0],r=this.items[t]||null;return delete this.items[t],r}},function(t,r,n){"use strict";var e=n(0);t.exports=function(){var t=e(this.items),r=void 0,n=void 0,i=void 0;for(i=t.length;i;i-=1)r=Math.floor(Math.random()*i),n=t[i-1],t[i-1]=t[r],t[r]=n;return this.items=t,this}},function(t,r,n){"use strict";t.exports=function(t,r){var n=this.items.slice(t);return void 0!==r&&(n=n.slice(0,r)),new this.constructor(n)}},function(t,r,n){"use strict";t.exports=function(t){var r=[].concat(this.items);return void 0===t?this.every(function(t){return"number"==typeof t})?r.sort(function(t,r){return t-r}):r.sort():r.sort(t),new this.constructor(r)}},function(t,r,n){"use strict";t.exports=function(t){var r=[].concat(this.items);return"function"==typeof t?r.sort(function(r,n){return t(r)<t(n)?-1:t(r)>t(n)?1:0}):r.sort(function(r,n){return r[t]<n[t]?-1:r[t]>n[t]?1:0}),new this.constructor(r)}},function(t,r,n){"use strict";t.exports=function(t){return this.sortBy(t).reverse()}},function(t,r,n){"use strict";t.exports=function(t,r,n){var e=this.slice(t,r);if(this.items=this.diff(e.all()).all(),Array.isArray(n))for(var i=0,o=n.length;i<o;i+=1)this.items.splice(t+i,0,n[i]);return e}},function(t,r,n){"use strict";t.exports=function(t){for(var r=Math.round(this.items.length/t),n=JSON.parse(JSON.stringify(this.items)),e=[],i=0;i<t;i+=1)e.push(new this.constructor(n.splice(0,r)));return new this.constructor(e)}},function(t,r,n){"use strict";t.exports=function(t){var r=0;if(void 0===t)for(var n=0,e=this.items.length;n<e;n+=1)r+=this.items[n];else if("function"==typeof t)for(var i=0,o=this.items.length;i<o;i+=1)r+=t(this.items[i]);else for(var s=0,u=this.items.length;s<u;s+=1)r+=this.items[s][t];return r}},function(t,r,n){"use strict";var e="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t};t.exports=function(t){var r=this;if(!Array.isArray(this.items)&&"object"===e(this.items)){var n=Object.keys(this.items),i=void 0;i=t<0?n.slice(t):n.slice(0,t);var o={};return n.forEach(function(t){-1!==i.indexOf(t)&&(o[t]=r.items[t])}),new this.constructor(o)}return t<0?new this.constructor(this.items.slice(t)):new this.constructor(this.items.slice(0,t))}},function(t,r,n){"use strict";t.exports=function(t){return t(this),this}},function(t,r,n){"use strict";t.exports=function(t,r){for(var n=1;n<=t;n+=1)this.items.push(r(n));return this}},function(t,r,n){"use strict";t.exports=function(){function t(n,e){var i=[];n instanceof r?(n.items.forEach(function(r){return t(r,i)}),e.push(i)):Array.isArray(n)?(n.forEach(function(r){return t(r,i)}),e.push(i)):e.push(n)}var r=this.constructor;if(Array.isArray(this.items)){var n=[];return this.items.forEach(function(r){t(r,n)}),n}return this.values().all()}},function(t,r,n){"use strict";t.exports=function(){return JSON.stringify(this.toArray())}},function(t,r,n){"use strict";t.exports=function(t){var r=this;if(Array.isArray(this.items))this.items=this.items.map(t);else{var n={};Object.keys(this.items).forEach(function(e){n[e]=t(r.items[e],e)}),this.items=n}return this}},function(t,r,n){"use strict";t.exports=function(t,r,n){t?n(this):r(this)}},function(t,r,n){"use strict";t.exports=function(t){var r=this,n=JSON.parse(JSON.stringify(this.items));return Object.keys(t).forEach(function(e){void 0===r.items[e]&&(n[e]=t[e])}),new this.constructor(n)}},function(t,r,n){"use strict";t.exports=function(t){var r=void 0;if(void 0===t)r=this.items.filter(function(t,r,n){return n.indexOf(t)===r});else{r=[];for(var n=[],e=0,i=this.items.length;e<i;e+=1){var o=void 0;o="function"==typeof t?t(this.items[e]):this.items[e][t],-1===n.indexOf(o)&&(r.push(this.items[e]),n.push(o))}}return new this.constructor(r)}},function(t,r,n){"use strict";t.exports=function(t){return t instanceof this.constructor?t.all():t}},function(t,r,n){"use strict";t.exports=function(){var t=this,r=[];return Object.keys(this.items).forEach(function(n){r.push(t.items[n])}),new this.constructor(r)}},function(t,r,n){"use strict";t.exports=function(t,r,n){t?r(this):n(this)}},function(t,r,n){"use strict";var e=n(0);t.exports=function(t,r,n){var i=r,o=n;void 0===n&&(o=r,i="===");var s=e(this.items).filter(function(r){switch(i){case"==":return r[t]===Number(o)||r[t]===o.toString();default:case"===":return r[t]===o;case"!=":case"<>":return r[t]!==Number(o)&&r[t]!==o.toString();case"!==":return r[t]!==o;case"<":return r[t]<o;case"<=":return r[t]<=o;case">":return r[t]>o;case">=":return r[t]>=o}});return new this.constructor(s)}},function(t,r,n){"use strict";var e=n(0);t.exports=function(t,r){var n=e(r),i=this.items.filter(function(r){return-1!==n.indexOf(r[t])});return new this.constructor(i)}},function(t,r,n){"use strict";var e=n(0);t.exports=function(t,r){var n=e(r),i=this.items;return n.forEach(function(r){i=i.filter(function(n){return n[t]!==r})}),new this.constructor(i)}},function(t,r,n){"use strict";var e="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t};t.exports=function(t){return t instanceof this.constructor?t:"object"===(void 0===t?"undefined":e(t))?new this.constructor(t):new this.constructor([t])}},function(t,r,n){"use strict";t.exports=function(t){var r=this,n=t;n instanceof this.constructor&&(n=n.all());var e=this.items.map(function(t,e){return new r.constructor([t,n[e]])});return new this.constructor(e)}}]);
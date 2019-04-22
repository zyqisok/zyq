/**
 * Base.js
 * @date 2019-04-22
 */

/**
 * 字符串判空
 * @param s 字符串
 * @returns true：空，false-非空
 */
function isEmpty(s){
	if(typeof(s) == "undefined" || s == null || s == "" || $.trim(s).length == 0){
		return true;
	}
	return false;
}

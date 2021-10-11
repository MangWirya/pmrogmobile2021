package com.example.pemrogmobile2021.model

import com.google.gson.annotations.SerializedName

data class ResponseUserPetani(

	@field:SerializedName("owner")
	val owner: Int? = null,

	@field:SerializedName("folders")
	val folders: List<Any?>? = null,

	@field:SerializedName("folders_order")
	val foldersOrder: List<Any?>? = null,

	@field:SerializedName("public")
	val jsonMemberPublic: Boolean? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("requests")
	val requests: List<RequestsItem?>? = null,

	@field:SerializedName("order")
	val order: List<String?>? = null,

	@field:SerializedName("timestamp")
	val timestamp: Long? = null
)

data class HelperAttributes(
	val any: Any? = null
)

data class QueryParamsItem(

	@field:SerializedName("equals")
	val equals: Boolean? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("enabled")
	val enabled: Boolean? = null
)

data class PathVariables(
	val any: Any? = null
)

data class RequestsItem(

	@field:SerializedName("headerData")
	val headerData: List<Any?>? = null,

	@field:SerializedName("headers")
	val headers: String? = null,

	@field:SerializedName("helperAttributes")
	val helperAttributes: HelperAttributes? = null,

	@field:SerializedName("method")
	val method: String? = null,

	@field:SerializedName("data")
	val data: Any? = null,

	@field:SerializedName("queryParams")
	val queryParams: List<Any?>? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("preRequestScript")
	val preRequestScript: Any? = null,

	@field:SerializedName("version")
	val version: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("pathVariableData")
	val pathVariableData: List<Any?>? = null,

	@field:SerializedName("dataMode")
	val dataMode: String? = null,

	@field:SerializedName("pathVariables")
	val pathVariables: PathVariables? = null,

	@field:SerializedName("tests")
	val tests: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("responses")
	val responses: List<Any?>? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("time")
	val time: Long? = null,

	@field:SerializedName("collectionId")
	val collectionId: String? = null,

	@field:SerializedName("descriptionFormat")
	val descriptionFormat: String? = null,

	@field:SerializedName("currentHelper")
	val currentHelper: String? = null,

	@field:SerializedName("rawModeData")
	val rawModeData: String? = null
)

data class DataItem(

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("enabled")
	val enabled: Boolean? = null
)

data class HeaderDataItem(

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("enabled")
	val enabled: Boolean? = null
)

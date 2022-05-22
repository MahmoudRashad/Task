package com.rashad.domain.authentication.extensions

import org.json.JSONArray


inline fun <reified T, R> JSONArray.mapNotNull(transform: (T) -> R): MutableList<R> =
    mapNotNullTo(mutableListOf(), transform)

inline fun <reified T, R> JSONArray.mapNotNullTo(
    to: MutableList<R>,
    transform: (T) -> R
): MutableList<R> =
    to.apply {
        (0..length()).forEach { i -> (get(i) as? T)?.let { add(transform(it)) } }
    }

inline fun <reified T, R> JSONArray.mapIndexed(transform: (index: Int, T?) -> R): MutableList<R?> =
    mapIndexedTo(mutableListOf(), transform)

inline fun <reified T, R> JSONArray.mapIndexedTo(
    to: MutableList<R?>,
    transform: (index: Int, T?) -> R?
): MutableList<R?> =
    (0..length()).mapTo(to, { i -> transform(i, get(i) as? T) })


// Iteration
inline fun <reified T> JSONArray.forEach(action: (T?) -> Unit) {
    (0..length()).forEach { action(get(it) as? T) }
}

inline fun <reified T> JSONArray.forEachIndexed(action: (index: Int, T?) -> Unit) {
    (0..length()).forEach { action(it, get(it) as? T) }
}

inline fun <reified T> JSONArray.forEachNotNull(action: (T) -> Unit) {
    (0..length()).forEach { action(get(it) as T) }
}


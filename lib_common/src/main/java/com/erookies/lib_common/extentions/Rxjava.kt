package com.erookies.lib_common.extentions

import com.erookies.lib_common.network.DefaultHandler
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Create by Cchanges.
 * Time: 2019-10-14
 */
fun <T> Observable<T>.setSchedulers(
    subscribeOn: Scheduler = Schedulers.io(),
    unSubscribeOn: Scheduler = Schedulers.io(),
    observeOn: Scheduler = AndroidSchedulers.mainThread()
): Observable<T> = subscribeOn(subscribeOn).unsubscribeOn(unSubscribeOn).observeOn(observeOn)

/**
 * 异常处理（不会消费onError事件，仍会回调观察者的onError）
 * 优先使用
 */
inline fun <T> Observable<T>.doOnErrorWithDefaultErrorHandler(
    defaultErrorHandler: DefaultHandler? = DefaultHandler,
    crossinline onError: (Throwable) -> Boolean
): Observable<T> = doOnError { if (!onError.invoke(it)) defaultErrorHandler?.handler(it) }

fun <T> Observable<T>.errorHandler(errorHandler: DefaultHandler = DefaultHandler) =
    doOnError { errorHandler.handler(it) }

/**
 * 未实现onError时不会抛出[io.reactivex.exceptions.OnErrorNotImplementedException]异常
 */
fun <T> Observable<T>.safeSubscribeBy(
    onError: (Throwable) -> Unit = {},
    onComplete: () -> Unit = {},
    onNext: (T) -> Unit = {}
): Disposable = subscribe(onNext, onError, onComplete)
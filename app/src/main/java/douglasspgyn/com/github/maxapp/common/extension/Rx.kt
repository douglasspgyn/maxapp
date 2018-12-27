package douglasspgyn.com.github.maxapp.common.extension

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.exceptions.OnErrorNotImplementedException
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers

private val onNextStub: (Any) -> Unit = { }
private val onErrorStub: (Throwable) -> Unit = { RxJavaPlugins.onError(OnErrorNotImplementedException(it)) }
private val onFinishStub: () -> Unit = {}

fun <T : Any> Single<T>.rx(
        onSuccess: (T) -> Unit = onNextStub,
        onError: (Throwable) -> Unit = onErrorStub,
        onFinish: () -> Unit = onFinishStub
): Disposable = doAfterTerminate { onFinish() }.subscribe(onSuccess, onError)

fun <T> Single<T>.applySchedulers(): Single<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}
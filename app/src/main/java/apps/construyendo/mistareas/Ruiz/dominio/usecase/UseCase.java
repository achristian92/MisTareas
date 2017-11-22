package apps.construyendo.mistareas.Presenter.dominio.usecase;

import apps.construyendo.mistareas.Presenter.dominio.executor.PostExecutionThread;
import apps.construyendo.mistareas.Presenter.dominio.executor.ThreadExecutor;

/**
 * Created by Christian 24 on 18/11/2017.
 */

public abstract class UseCase<T> {
    private ThreadExecutor threadExecutor;
    private PostExecutionThread postExecutionThread;
    private Callback<T> callback;

    //CREAMOS UN CONSTRUCCTOR
    protected UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    protected void notificarUseCaseSatisfactorio(final T reponse){
        postExecutionThread.execute(new Runnable() {
            @Override
            public void run() {
                if(callback!=null){
                    callback.onSuccess(reponse);
                }
            }
        });
    }

    protected void notificarUseCaseError(final Throwable throwable){
        postExecutionThread.execute(new Runnable() {
            @Override
            public void run() {
                if(callback!=null){
                    callback.onError(throwable);
                }
            }
        });
    }


    public void ejecutar(final Callback<T> callback){
        this.callback=callback;
        threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                contruirUseCase();
            }
        });
    }

    protected abstract void contruirUseCase();


    public interface Callback<T>{
    void onSuccess(T response);
    void onError(Throwable t);
    }
}

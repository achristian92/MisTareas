package apps.construyendo.mistareas.Presenter.dominio.usecase;


import apps.construyendo.mistareas.Presenter.dominio.executor.PostExecutionThread;
import apps.construyendo.mistareas.Presenter.dominio.executor.ThreadExecutor;
import apps.construyendo.mistareas.Presenter.dominio.model.Tareas;
import apps.construyendo.mistareas.Presenter.dominio.repository.TareaRepositorio;

/**
 * Created by Christian 24 on 18/11/2017.
 */

public class GuardarTarea extends UseCase<Tareas> {

    private final TareaRepositorio tareaRepository;
    private Tareas tareas;

    public GuardarTarea(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, TareaRepositorio tareaRepository) {
        super(threadExecutor, postExecutionThread);
        this.tareaRepository = tareaRepository;
    }

    @Override
    protected void contruirUseCase() {
        try {
            Tareas tareas=this.tareaRepository.crearTarea(this.tareas);
            notificarUseCaseSatisfactorio(tareas);

        }catch (Exception e){
            notificarUseCaseError(e);
        }
    }
    public void setParams(Tareas tareas){
        this.tareas=tareas;
    }
}

package apps.construyendo.mistareas.Presenter.dominio.usecase;

import java.util.List;


import apps.construyendo.mistareas.Presenter.dominio.executor.PostExecutionThread;
import apps.construyendo.mistareas.Presenter.dominio.executor.ThreadExecutor;
import apps.construyendo.mistareas.Presenter.dominio.model.Tareas;
import apps.construyendo.mistareas.Presenter.dominio.repository.TareaRepositorio;

/**
 * Created by Christian 24 on 18/11/2017.
 */

public class ListarTareas extends UseCase<List<Tareas>> {
    private final TareaRepositorio tareaRepository;

    protected ListarTareas(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,TareaRepositorio tareaRepository) {
        super(threadExecutor, postExecutionThread);
        this.tareaRepository=tareaRepository;
    }

    @Override
    protected void contruirUseCase(){

        try {
            List<Tareas> tareasList=this.tareaRepository.listarTareas();
            notificarUseCaseSatisfactorio(tareasList);
        } catch (Exception e) {
            notificarUseCaseError(e);
        }

    }
}

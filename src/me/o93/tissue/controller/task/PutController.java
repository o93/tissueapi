package me.o93.tissue.controller.task;

import me.o93.tissue.meta.TaskMeta;
import me.o93.tissue.model.Task;
import me.o93.tissue.service.TaskService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class PutController extends Controller {

    private TaskService service = new TaskService();

    @Override
    public Navigation run() throws Exception {
        Task task = service.put(request);
        
        String taskJson = TaskMeta.get().modelToJson(task);
        // TODO: ...
        return null;
    }
}

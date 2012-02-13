package me.o93.tissue.controller.task;

import javax.servlet.http.HttpServletResponse;

import me.o93.tissue.meta.TaskMeta;
import me.o93.tissue.model.Task;
import me.o93.tissue.service.TaskService;
import me.o93.tissue.utils.JsonWriter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class PutController extends Controller {

    private TaskService service = new TaskService();

    @Override
    public Navigation run() throws Exception {
        if (!isPost()) {
            JsonWriter.write(
                response,
                HttpServletResponse.SC_BAD_REQUEST,
                "err_http_method",
                "Please, this request is post.");
            return null;
        }
        // TODO:Error response..mmm
        Task task = service.put(request);
        
        String responseBody = TaskMeta.get().modelToJson(task, 2);
        JsonWriter.write(response, responseBody);
        
        return null;
    }
}

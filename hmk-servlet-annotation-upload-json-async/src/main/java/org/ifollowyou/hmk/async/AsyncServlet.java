package org.ifollowyou.hmk.async;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "asyncServlet", value = {"/async"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    String param = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1.0 start async
        final AsyncContext ctx = req.startAsync();
        param = ctx.getRequest().getParameter("seq");

        // 2.0 set the timeout
        ctx.setTimeout(0);

        // 3.0 add listener
        ctx.addListener(new AsyncListener() {
            public void onTimeout(AsyncEvent arg0) throws IOException {
                System.out.println("onTimeout...");
            }

            public void onStartAsync(AsyncEvent arg0) throws IOException {
                System.out.println("onStartAsync...");
            }

            public void onError(AsyncEvent arg0) throws IOException {
                System.out.println("onError...");
            }

            public void onComplete(AsyncEvent arg0) throws IOException {
                System.out.println("onComplete...");
            }
        });

        // 4.0 run a thread
        ctx.start(new Runnable() {
            @Override
            public void run() {
                try {
                    // hold until receive exit
                    while (!param.equals("exit")) {
                        try {
                            Thread.sleep(2000);
                            String msg = "param="+System.currentTimeMillis();
                            System.out.println(msg);
//                            ctx.getResponse().getWriter().write(msg);
//                            ctx.getResponse().getWriter().flush();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String seq = ctx.getRequest().getParameter("seq");
                    System.out.println("seq=" + seq);
                    ctx.getResponse().getWriter().write(seq);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                ctx.complete();
            }
        });
    }
}

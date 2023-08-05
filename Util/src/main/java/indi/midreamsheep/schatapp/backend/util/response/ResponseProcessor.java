package indi.midreamsheep.schatapp.backend.util.response;

import com.alibaba.druid.support.spring.stat.annotation.Stat;
import com.google.gson.Gson;
import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Create response string or send a response via ChannelHandlerContext
 * @author lsk
 */
public final class ResponseProcessor {

    // Gson serializer
    private static final Gson gson = new Gson();

    /**
     * Process an exception and generate a response string
     * @param t The exception instance
     * @return response
     */
    public static String makeResponse(Throwable t) {
        Map<String, Object> response = new HashMap<>();
        if (t instanceof StatusCode) {
            StatusCode statusCode = (StatusCode) t;
            response.put("code", statusCode.getCode());
            response.put("message", statusCode.getMessage());
            // response the packed exception if there is
            // format: <exception class name>: <exception message>
            response.put("exception",
                    statusCode.getCause() != null ?
                            statusCode.getCause().getClass().getName() + ": " + statusCode.getCause().getMessage()
                            : ""
            );
            response.put("messageId", statusCode.getMessageId());
        } else {
            response.put("code", 500);
            response.put("message", ResultEnum.ERROR.getMsg());
            response.put("exception", t.getClass().getName() + ": " + t.getMessage());
            response.put("messageId", -1);
        }
        return gson.toJson(response);
    }

    /**
     * Generate a response with given message and code
     * @param message message
     * @param code status code
     * @return response string
     */
    public static String makeResponse(String message, int code) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", code);
        response.put("message", message);
        return gson.toJson(response);
    }

    /**
     * Generate a successful response with given data
     * @param data data
     * @return response string
     */
    public static String makeResponse(Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 200);
        response.put("message", ResultEnum.SUCCESS.getMsg());
        response.put("data", data);
        return gson.toJson(response);
    }

    /**
     * Generate a response with resultEnum
     * @param resultEnum result status
     * @return response string
     */
    public static String makeResponse(ResultEnum resultEnum) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", resultEnum.getCode());
        response.put("message", resultEnum.getMsg());
        return gson.toJson(response);
    }

    /**
     * Write a failed response to ctx
     * @param ctx the context to write to
     * @param throwable the exception instance used to generate response
     */
    public static void sendFailedResponseToContext(ChannelHandlerContext ctx, Throwable throwable) {
        String response = makeResponse(throwable);
        ctx.writeAndFlush(response);
    }

    /**
     * Write a response to ctx
     * @param ctx the context to write to
     * @param resultEnum result enum
     * @param message message
     */
    public static void sendResponseToContext(ChannelHandlerContext ctx, ResultEnum resultEnum, String message) {
        String response = makeResponse(message, resultEnum.getCode());
        ctx.writeAndFlush(response);
    }

    /**
     * Write a response to ctx
     * @param ctx the context to write to
     * @param resultEnum result status
     */
    public static void sendResponseToContext(ChannelHandlerContext ctx, ResultEnum resultEnum) {
        String response = makeResponse(resultEnum);
        ctx.writeAndFlush(response);
    }

    /**
     * Write a successful response to ctx
     * @param ctx the context to write
     * @param data the data to respond
     */
    public static void sendResponseToContext(ChannelHandlerContext ctx, Object data) {
        String response = makeResponse(data);
        ctx.writeAndFlush(response);
    }
}

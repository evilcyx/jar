package com.example.admin.mvp_master.tools.toast;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.admin.mvp_master.R;

import java.lang.reflect.Field;

/**
 * Created by admin on 2018/4/2.
 */

public class ToastUtil extends Toast {

    private static Toast mToast;

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public ToastUtil(Context context) {
        super(context);
    }

    /**
     * 弹出土司提示
     *
     * @param context
     * @param text
     * @return
     */
    public static void showToastForStorage(Context context, String text) {
        showToast(context, text);
    }


    /**
     * 弹出 长时间 普通Toast
     *
     * @param context
     * @param string
     */
    public static void showToastLengthTime(Context context, String string) {
        showToast(context, string);
    }

    /**
     * 弹出 短时间 普通Toast
     *
     * @param context
     * @param string
     */
    public static void showToastShortTime(Context context, String string) {
        showToast(context, string);
    }

    public static void showToastDefault(Context context, String text) {
        showToast(context, text);
    }

    public static Toast showToastD(Context context, CharSequence text) {
        Toast toast = MyToast.makeTextAnim(context, text, 0, R.style.anim_view);
        return toast;
    }

    public static void showToastNotNetworkConnected(Context context) {
        showToast(context, "网络开小差,请稍后重试");
    }

    /**
     * toast带动画
     * @param context
     * @param msg
     * @return
     */
    public static Toast showToastAnimation(Context context, String msg) {
        Toast toast = makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);

        try {
            Object mTN = null;
            mTN = getField(toast, "mTN");

            if (mTN != null) {
                Object mParams = getField(mTN, "mParams");
                if (mParams != null && mParams instanceof WindowManager.LayoutParams) {
                    WindowManager.LayoutParams params = (WindowManager.LayoutParams) mParams;
                    params.windowAnimations = R.style.anim_view;
                }
            }
        } catch (Exception e) {

        }
        return toast;
    }

    /**
     * 反射
     * @param object
     * @param fieldName
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static Object getField(Object object, String fieldName)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        if (field != null) {
            field.setAccessible(true);
            return field.get(object);
        }
        return null;
    }

    /**
     * toast
     * @param context
     * @param msg
     */
    public static void showToast(Context context, String msg) {
        if (mToast == null) {
            mToast = showToastAnimation(context, msg);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }


}

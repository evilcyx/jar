package com.example.admin.mvp_master.tools.toast;

import android.content.Context;
import android.view.WindowManager;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MyToast extends Toast {

	public MyToast(Context context) {
		super(context);
	}

	/**
	 * �����ж�����Toast
	 * @param context
	 * @param text
	 * @param duration
	 * @param �Զ���Ķ���id
	 * @return
	 */
	public static Toast makeTextAnim(Context context, CharSequence text,
									 int duration, int styleId) {
		Toast toast = makeText(context, text, duration);
		toast.setText(text);
		toast.setDuration(duration);

		try {
			Object mTN = null;
			mTN = getField(toast, "mTN");
			if (mTN != null) {
				Object mParams = getField(mTN, "mParams");
				if (mParams != null
						&& mParams instanceof WindowManager.LayoutParams) {
					WindowManager.LayoutParams params = (WindowManager.LayoutParams) mParams;
					params.windowAnimations = styleId;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return toast;
	}

	/**
	 * �����ֶ�
	 * @param object Ҫ����Ķ���
	 * @param fieldName Ҫ������ֶ�����
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

}

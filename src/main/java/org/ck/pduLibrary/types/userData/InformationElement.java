package org.ck.pduLibrary.types.userData;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.ck.pduLibrary.annotations.InfoElement;
import org.ck.pduLibrary.types.PduType;
import org.reflections.Reflections;

public abstract class InformationElement implements PduType
{

	private static Map<Integer, Class<InformationElement>> availableInformationElements;

	public abstract Integer getLength();

	public abstract Boolean isRepeatable();

	public abstract byte[] asByteArray();

	public static InformationElement valueOf(byte[] informationElement)
	{
		if (informationElement != null && informationElement.length > 0)
		{
			Integer identifier = new Integer(informationElement[0]);

			if (availableInformationElements == null)
			{
				availableInformationElements = getAvailableInformationElements();
			}

			Class<InformationElement> elementClass = availableInformationElements.get(identifier);

			try
			{
				Method valueOfMethod = elementClass.getMethod("valueOf", byte[].class);

				return (InformationElement) valueOfMethod.invoke(null,
						Arrays.copyOfRange(informationElement, 1, informationElement.length));
			}
			catch (Exception e)
			{
				e.printStackTrace();
				// TODO
			}
		}

		return null;
	}

	private static Map<Integer, Class<InformationElement>> getAvailableInformationElements()
	{
		Map<Integer, Class<InformationElement>> newAvailableInformationElements =
				new HashMap<Integer, Class<InformationElement>>();

		Reflections reflections = new Reflections("org.ck.pduLibrary");

		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(InfoElement.class);

		for (Class<?> prospectInformationElementClass : annotated)
		{
			if (InformationElement.class.isAssignableFrom(prospectInformationElementClass))
			{
				@SuppressWarnings("unchecked")
				Class<InformationElement> informationElementClass =
						(Class<InformationElement>) prospectInformationElementClass;

				InfoElement annotation = informationElementClass.getAnnotation(InfoElement.class);

				newAvailableInformationElements.put(annotation.indication(), informationElementClass);
			}
		}

		return newAvailableInformationElements;
	}

}

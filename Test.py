import asyncio
from llama_index.llms.google_genai import GoogleGenAI
from droidrun import DroidAgent, AdbTools

async def main():
    # load adb tools for the first connected device
    tools = await AdbTools.create()

    # Set up the Gemini LLM
    llm = GoogleGenAI(
        api_key="AIzaSyBfTl8ctnt_hrdXCtqFmjh-C77REG2Uu5g",  # Replace with your Gemini API key
        model="gemini-2.5-flash",  # or "gemini-2.5-pro" for enhanced reasoning
    )

    # Create the DroidAgent
    agent = DroidAgent(
        goal="Open Settings and check battery level",
        llm=llm,
        tools=tools,
        vision=True,      # Set to True for vision models, False for text-only
        reasoning=False,  # Optional: enable planning/reasoning
    )

    # Run the agent
    result = await agent.run()
    print(f"Success: {result['success']}")
    if result.get('output'):
        print(f"Output: {result['output']}")

if __name__ == "__main__":
    asyncio.run(main())

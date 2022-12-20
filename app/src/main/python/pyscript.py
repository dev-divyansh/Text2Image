import openai
def main(DATA):
    secret = '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'
    openai.api_key = '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'
    response = openai.Image.create(
    prompt=DATA,
    n=1,
    size="1024x1024"
    )
    return response['data'][0]['url']


